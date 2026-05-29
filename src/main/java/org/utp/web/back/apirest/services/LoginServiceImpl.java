package org.utp.web.back.apirest.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import org.utp.web.back.ejb.entities.Cliente;
import org.utp.web.back.ejb.entities.Usuario;
import org.utp.web.back.ejb.services.AutorizacionService;
import org.utp.web.back.apirest.models.dto.ClienteDTO;
import org.utp.web.back.apirest.models.dto.LoginDTO;
import org.utp.web.back.apirest.models.dto.LoginJWT;
import org.utp.web.back.apirest.models.mappers.ClienteMapper;
import org.utp.web.back.apirest.security.DatabaseIdentityStore;
import org.utp.web.back.apirest.util.TokenJwtConfig;

import java.text.SimpleDateFormat;
import java.util.Date;

@ApplicationScoped
public class LoginServiceImpl implements LoginService{

    // 1. Inyectamos la interfaz oficial de Jakarta Security
    //@Inject private IdentityStore identityStore;
    @Inject
    private DatabaseIdentityStore identityStore;

    //@EJB(lookup = "ejb:/web-back-ejb/AutorizacionServiceImpl!org.utp.web.back.ejb.services.AutorizacionService")
    @Inject
    private AutorizacionService autorizacionServiceRemote;

    @Inject
    private ClienteMapper clienteMapper;

    @Override
    public LoginJWT loginClienteJWT(LoginDTO loginDTO) {

        /*
        // 1. OBTENER EL EJB MANUALMENTE (Escondido de CDI)
        AutorizacionService autorizacionServiceRemote;
        try {
            javax.naming.InitialContext ctx = new javax.naming.InitialContext();
            // Buscamos el EJB directamente en la memoria RAM de WildFly
            autorizacionServiceRemote = (AutorizacionService) ctx.lookup("ejb:/web-back-ejb/AutorizacionServiceImpl!org.utp.web.back.ejb.services.AutorizacionService");
        } catch (javax.naming.NamingException e) {
            e.printStackTrace();
            throw new WebApplicationException("Error crítico: No se puede conectar con el backend EJB", Response.Status.INTERNAL_SERVER_ERROR);
        }*/

        System.out.println("autorizacionServiceRemote= " + autorizacionServiceRemote.login(loginDTO.getUsuario(), 1));

        // 2. Empaquetamos las credenciales que vienen de Postman
        UsernamePasswordCredential credential = new UsernamePasswordCredential(loginDTO.getUsuario(), loginDTO.getClave());

        // 3. AQUI ES DONDE SE LLAMA A TU METODO validate()
        CredentialValidationResult result = identityStore.validate(credential);

        // 4. Verificamos si la validación fue exitosa
        if (result.getStatus() == CredentialValidationResult.Status.VALID) {
            // ¡Credenciales correctas! Extraemos el correo validado
            String correoValidado = result.getCallerPrincipal().getName();

            Cliente cliente = autorizacionServiceRemote.login(correoValidado, 1);

            Claims claims = Jwts.claims()
                    .add("id", cliente.getId())
                    .add("useremail", cliente.getCorreo())
                    .add("nombres", cliente.getNombres())
                    .add("apellidos", cliente.getApellidos())
                    .build();

            long nowMillis = System.currentTimeMillis();
            Date issuedAt = new Date(nowMillis);
            Date expirationDate = new Date(nowMillis + (TokenJwtConfig.EXPIRATION_IN_MINUTES * 60 * 1000L)); // Nota la 'L' al final para forzar operaciones con Long

            String token = Jwts.builder()
                    .subject("CLIENTE")
                    .claims(claims)
                    .issuedAt(issuedAt)
                    .expiration(expirationDate)
                    .signWith(TokenJwtConfig.SECRET_KEY)
                    .compact();

            //Inicio Extraer Datos
            // 1. Usas la nueva sintaxis de JJWT y le pasas tu SECRET_KEY directamente
            Claims claimsDecode = Jwts.parser()
                    .verifyWith(TokenJwtConfig.SECRET_KEY)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

            // 2. Extraer las fechas
            SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date fechaEmision = claimsDecode.getIssuedAt();
            Date fechaExpiracion = claimsDecode.getExpiration();

            String emisionString = formateador.format(fechaEmision);
            String expiracionString = formateador.format(fechaExpiracion);
            //Fin Extraer Datos

            LoginJWT loginJWT = new LoginJWT(token, fechaEmision, fechaExpiracion);

            return loginJWT;
        }

        // 5. Si la clave o el usuario son incorrectos, lanzamos un error 401
        throw new WebApplicationException("Credenciales inválidas", Response.Status.UNAUTHORIZED);
    }

    @Override
    public ClienteDTO registrarCliente(ClienteDTO clienteDTO) {
        System.out.println("registrarCliente");

        clienteDTO.setClave( identityStore.encode(clienteDTO.getClave()) );
        System.out.println("clienteDTO= " + clienteDTO);

        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        System.out.println("Cliente= " + cliente);

        Cliente clienteDB = autorizacionServiceRemote.registrar(cliente);
        System.out.println("ClienteDB= " + clienteDB);

        if ( clienteDB != null ){
            ClienteDTO clienteDTODB = clienteMapper.toDTO( clienteDB );
            return clienteDTODB;
        }else{
            return null;
        }
    }

    @Override
    public LoginJWT loginUsuarioJWT(LoginDTO loginDTO) {

        System.out.println("autorizacionServiceRemote= " + autorizacionServiceRemote.loginUsuario(loginDTO.getUsuario(), 1));

        // 2. Empaquetamos las credenciales que vienen de Postman
        UsernamePasswordCredential credential = new UsernamePasswordCredential(loginDTO.getUsuario(), loginDTO.getClave());

        // 3. AQUI ES DONDE SE LLAMA A TU METODO validate()
        CredentialValidationResult result = identityStore.validate(credential);

        // 4. Verificamos si la validación fue exitosa
        if (result.getStatus() == CredentialValidationResult.Status.VALID) {
            // ¡Credenciales correctas! Extraemos el correo validado
            String correoValidado = result.getCallerPrincipal().getName();

            Usuario usuario = autorizacionServiceRemote.loginUsuario(correoValidado, 1);

            Claims claims = Jwts.claims()
                    .add("id", usuario.getId())
                    .add("useremail", usuario.getUsuario())
                    .add("nombres", usuario.getNombres())
                    .add("apellidos", usuario.getApellidos())
                    .build();

            long nowMillis = System.currentTimeMillis();
            Date issuedAt = new Date(nowMillis);
            Date expirationDate = new Date(nowMillis + (TokenJwtConfig.EXPIRATION_IN_MINUTES * 60 * 1000L)); // Nota la 'L' al final para forzar operaciones con Long

            String token = Jwts.builder()
                    .subject("USUARIO")
                    .claims(claims)
                    .issuedAt(issuedAt)
                    .expiration(expirationDate)
                    .signWith(TokenJwtConfig.SECRET_KEY)
                    .compact();

            //Inicio Extraer Datos
            // 1. Usas la nueva sintaxis de JJWT y le pasas tu SECRET_KEY directamente
            Claims claimsDecode = Jwts.parser()
                    .verifyWith(TokenJwtConfig.SECRET_KEY)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

            // 2. Extraer las fechas
            SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date fechaEmision = claimsDecode.getIssuedAt();
            Date fechaExpiracion = claimsDecode.getExpiration();

            String emisionString = formateador.format(fechaEmision);
            String expiracionString = formateador.format(fechaExpiracion);
            //Fin Extraer Datos

            LoginJWT loginJWT = new LoginJWT(token, fechaEmision, fechaExpiracion);

            return loginJWT;
        }

        // 5. Si la clave o el usuario son incorrectos, lanzamos un error 401
        throw new WebApplicationException("Credenciales inválidas", Response.Status.UNAUTHORIZED);
    }

}

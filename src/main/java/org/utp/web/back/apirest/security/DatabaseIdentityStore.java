package org.utp.web.back.apirest.security;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.security.enterprise.credential.Credential;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStore;
import jakarta.security.enterprise.identitystore.Pbkdf2PasswordHash;
import org.utp.web.back.ejb.entities.Cliente;
import org.utp.web.back.ejb.entities.Usuario;
import org.utp.web.back.ejb.services.AutorizacionService;
import org.utp.web.back.apirest.util.LoginTypeContext;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@ApplicationScoped
public class DatabaseIdentityStore implements IdentityStore {

    @Inject
    private AutorizacionService autorizacionServiceRemote;

    @Inject
    private Pbkdf2PasswordHash passwordHash;

    @Inject
    private LoginTypeContext loginContext;

    /**
     * Equivalente a passwordEncoder.encode() de Spring
     */
    public String encode(String rawPassword) {
        // Jakarta EE requiere que enviemos la contraseña como arreglo de caracteres (char[]) por seguridad
        return passwordHash.generate(rawPassword.toCharArray());
    }

    /**
     * Equivalente a passwordEncoder.matches() de Spring
     */
    public boolean matches(String rawPassword, String encodedPassword) {
        return passwordHash.verify(rawPassword.toCharArray(), encodedPassword);
    }

    @PostConstruct
    public void init() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("Pbkdf2PasswordHash.Iterations", "3072");
        parameters.put("Pbkdf2PasswordHash.Algorithm", "PBKDF2WithHmacSHA256");
        parameters.put("Pbkdf2PasswordHash.SaltSizeBytes", "64");
        passwordHash.initialize(parameters);
    }

    @Override
    public CredentialValidationResult validate(Credential credential) {
        System.out.println("validate");
        if (credential instanceof UsernamePasswordCredential userCredential) {
            String username = userCredential.getCaller();
            String password = userCredential.getPasswordAsString();

            Cliente cliente = null;

            if ( loginContext.isUsuarioLogin() ){
                Usuario usuario = autorizacionServiceRemote.loginUsuario(username, 1);
                if ( usuario != null ){
                    cliente = new Cliente();
                    cliente.setId(usuario.getId());
                    cliente.setNombres(usuario.getNombres());
                    cliente.setApellidos(usuario.getApellidos());
                    cliente.setEstado(usuario.getEstado());
                    cliente.setCorreo(usuario.getUsuario());
                    cliente.setClave(usuario.getClave());
                } else {
                    return CredentialValidationResult.INVALID_RESULT;
                }
            } else {
                cliente = autorizacionServiceRemote.login(username, 1);
            }

            if (cliente == null) {
                return CredentialValidationResult.INVALID_RESULT;
            }

            System.out.println("Clave encriptada String= " + passwordHash.generate("123456789".toCharArray()));
            System.out.println("Clave encriptada= " + passwordHash.generate(cliente.getClave().toCharArray()));

            // Validar contraseña hasheada
            if (passwordHash.verify(password.toCharArray(), cliente.getClave())) {
                System.out.println("Credenciales válidas");
                return new CredentialValidationResult(username , new HashSet<>());
            }
        }
        return CredentialValidationResult.INVALID_RESULT;
    }
}

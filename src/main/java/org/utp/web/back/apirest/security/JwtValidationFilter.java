package org.utp.web.back.apirest.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import jakarta.ws.rs.ext.Provider;
import org.utp.web.back.ejb.entities.Cliente;
import org.utp.web.back.ejb.services.AutorizacionService;
import org.utp.web.back.apirest.util.TokenJwtConfig;

import java.io.IOException;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@Provider
@Priority(Priorities.AUTHENTICATION) // Asegura que se ejecute primero
public class JwtValidationFilter implements ContainerRequestFilter {

    @Inject
    private AutorizacionService autorizacionServiceRemote;

    private static final List<String> RUTAS_PERMITIDAS = Arrays.asList(
            "/autorizacion/login",
            "/ubigeo",
            "/departamento/listado",
            "/grupo/listadopordepar",
            "/categoria/listadoporgrupo",
            "/marca/listado",
            "/producto/listadoporcategoria",
            "/producto/listadoporcategoriaymarca",
            "/publico"
    );

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        // 1. Omitir rutas públicas (Equivalente al AntPathMatcher)
        /*String path = requestContext.getUriInfo().getPath();
        System.out.println("Filtro JWT interceptó la ruta: '" + path + "'");
        if (path.startsWith("autorizacion/login") || path.startsWith("/autorizacion/login")) {
            return; // Deja pasar la petición
        }*/
        String path = requestContext.getUriInfo().getPath();
        System.out.println("Filtro JWT intercepto la ruta: '" + path + "'");
        // Normalizamos la ruta para garantizar que siempre empiece con '/'
        // Esto evita tener que guardar duplicados en la lista.
        String rutaNormalizada = path.startsWith("/") ? path : "/" + path;
        // Verificamos si la ruta normalizada empieza con alguna de las rutas de nuestra lista
        boolean esRutaPermitida = RUTAS_PERMITIDAS.stream()
                .anyMatch(ruta -> rutaNormalizada.startsWith(ruta));
        System.out.println("esRutaPermitida= " + esRutaPermitida);
        if ( esRutaPermitida ) {
            return; // Deja pasar la petición
        }

        // 2. Extraer y validar el Header
        String authHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        if (authHeader == null || !authHeader.startsWith(TokenJwtConfig.PREFIX_TOKEN)) {
            abortarPeticion(requestContext, "Cabecera de autorización faltante o incorrecta.");
            return;
        }

        String jwtToken = authHeader.substring(TokenJwtConfig.PREFIX_TOKEN.length());

        try {
            // 3. Validar token con JJWT
            Claims claims = Jwts.parser()
                    .verifyWith(TokenJwtConfig.SECRET_KEY)
                    .build()
                    .parseSignedClaims(jwtToken)
                    .getPayload();

            String userEmail = claims.get("useremail", String.class);
            if (userEmail == null) {
                abortarPeticion(requestContext, "Token inválido: Sin usuario.");
                return;
            }

            // 4. Validar contra la BD
            Cliente cliente = autorizacionServiceRemote.login(userEmail, 1);
            if (cliente == null) {
                abortarPeticion(requestContext, "Usuario no existe o está inactivo.");
                return;
            }

            // 5. Establecer el SecurityContext de JAX-RS (Reemplaza a SecurityContextHolder de Spring)
            requestContext.setSecurityContext(new SecurityContext() {
                @Override
                public Principal getUserPrincipal() {
                    return () -> userEmail; // Establece el usuario autenticado
                }

                @Override
                public boolean isUserInRole(String role) {
                    return false; // Aquí puedes implementar validación de roles si la tienes
                }

                @Override
                public boolean isSecure() {
                    return requestContext.getUriInfo().getAbsolutePath().toString().startsWith("https");
                }

                @Override
                public String getAuthenticationScheme() {
                    return "Bearer";
                }
            });
        } catch (JwtException e) {
            abortarPeticion(requestContext, "El token JWT es inválido o ha expirado.");
        }
    }

    // Metodo auxiliar para devolver un 401 estructurado (Reemplaza al ExceptionResolver)
    private void abortarPeticion(ContainerRequestContext requestContext, String mensaje) {
        String jsonError = String.format("{\"error\": \"%s\"}", mensaje);
        requestContext.abortWith(
                Response.status(Response.Status.UNAUTHORIZED)
                        .entity(jsonError)
                        .type(MediaType.APPLICATION_JSON)
                        .build()
        );
    }
}

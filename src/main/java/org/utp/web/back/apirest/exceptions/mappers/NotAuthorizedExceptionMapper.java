package org.utp.web.back.apirest.exceptions.mappers;

import jakarta.ws.rs.NotAuthorizedException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.HashMap;
import java.util.Map;

@Provider
public class NotAuthorizedExceptionMapper implements ExceptionMapper<NotAuthorizedException> {

    @Override
    public Response toResponse(NotAuthorizedException ex) {
        Map<String, String> body = new HashMap<>();

        body.put("message", "Error en la autenticación: username o password incorrectos!");
        // ex.getMessage() capturará el texto que envíes al momento de lanzar la excepción
        body.put("error", ex.getMessage() != null ? ex.getMessage() : "Credenciales inválidas");

        return Response.status(Response.Status.UNAUTHORIZED)
                .entity(body)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

}

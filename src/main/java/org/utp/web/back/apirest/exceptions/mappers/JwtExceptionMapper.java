package org.utp.web.back.apirest.exceptions.mappers;

import io.jsonwebtoken.JwtException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.HashMap;
import java.util.Map;

@Provider
public class JwtExceptionMapper implements ExceptionMapper<JwtException> {

    @Override
    public Response toResponse(JwtException ex) {
        Map<String, String> body = new HashMap<>();
        body.put("message", "¡El token JWT es inválido o ha expirado!");
        body.put("error", ex.getMessage());

        return Response.status(Response.Status.UNAUTHORIZED)
                .entity(body)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

}

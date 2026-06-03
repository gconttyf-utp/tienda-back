package org.utp.web.back.apirest.exceptions.mappers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.utp.web.back.apirest.exceptions.APIException;
import org.utp.web.back.apirest.exceptions.ErrorResponse;

import java.time.LocalDateTime;

// @Provider le dice al servidor que esta clase interceptará errores globalmente
@Provider
public class APIExceptionMapper implements ExceptionMapper<APIException> {

    @Context
    private HttpServletRequest request;

    @Override
    public Response toResponse(APIException ex) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(ex.getCodigoHttp())
                .error(Response.Status.fromStatusCode(ex.getCodigoHttp()).getReasonPhrase())
                .codigoInterno(ex.getCodigoInterno())
                .message(ex.getMessage())
                .path(request.getMethod() + " " + request.getRequestURI())
                .build();

        // Equivalente exacto a ResponseEntity.status(...).body(...)
        return Response.status(ex.getCodigoHttp())
                .entity(errorResponse)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

}

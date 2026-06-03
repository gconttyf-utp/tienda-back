package org.utp.web.back.apirest.exceptions.mappers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.utp.web.back.apirest.exceptions.ErrorResponse;

import java.time.LocalDateTime;

@Provider
public class WebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException> {

    @Context
    private HttpServletRequest request;

    @Override
    public Response toResponse(WebApplicationException ex) {
        // Extraemos el código HTTP nativo (Ej. 400 o 404)
        int status = ex.getResponse().getStatus();

        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(status)
                .error(Response.Status.fromStatusCode(status).getReasonPhrase())
                .codigoInterno(-1)
                // Mensaje genérico para cubrir rutas mal formadas o tipos de datos erróneos
                .message("Error en los parámetros de la petición o ruta no encontrada.")
                .path(request.getMethod() + " " + request.getRequestURI())
                .build();

        return Response.status(status)
                .entity(errorResponse)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

}

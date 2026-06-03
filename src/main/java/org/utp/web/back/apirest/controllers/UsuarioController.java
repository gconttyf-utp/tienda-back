package org.utp.web.back.apirest.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.utp.web.back.apirest.exceptions.APIException;
import org.utp.web.back.apirest.models.dto.UsuarioDTO;
import org.utp.web.back.ejb.services.UsuarioEjbService;

import java.util.List;

@Path("/usuario/usuarios")
public class UsuarioController {

    @Inject
    private UsuarioEjbService usuarioEjbService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar(@QueryParam("estado") List<Integer> estadosQuery){
        List<Integer> estados = (estadosQuery == null || estadosQuery.isEmpty()) ? List.of(0, 1) : estadosQuery;

        List<UsuarioDTO> listado = usuarioEjbService.listado(estados);

        if (listado.isEmpty()){
            throw new APIException(404, -1, String.format("No hay usuarios"));
        }
        return Response.ok().entity( listado ).build();
    }

}

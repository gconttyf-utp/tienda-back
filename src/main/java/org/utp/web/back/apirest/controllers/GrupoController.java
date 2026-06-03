package org.utp.web.back.apirest.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

import org.utp.web.back.apirest.exceptions.APIException;
import org.utp.web.back.apirest.models.dto.GrupoDTO;
import org.utp.web.back.ejb.services.GrupoEjbService;

@Path("/usuario/grupos")
public class GrupoController {

    @Inject
    private GrupoEjbService grupoEjbService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar(@QueryParam("codigo") Integer codDepartamento, @QueryParam("estado") List<Integer> estadosQuery){
        List<Integer> estados = (estadosQuery == null || estadosQuery.isEmpty()) ? List.of(0, 1) : estadosQuery;

        List<GrupoDTO> listado = grupoEjbService.listado(codDepartamento, estados);

        if (listado.isEmpty()){
            throw new APIException(404, -1, String.format("No hay grupos"));
        }
        return Response.ok().entity( listado ).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response encontrarId(@PathParam("id") Integer id){
        GrupoDTO oDTO = grupoEjbService.encontrarId(id);

        if (oDTO == null){
            throw new APIException(404, -1, String.format("No hay grupo con el id %d", id));
        }
        return Response.ok().entity( oDTO ).build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response nuevo(GrupoDTO oDTO){
        GrupoDTO oBD = grupoEjbService.save(null, oDTO);

        if ( oBD.getId() == null ){
            throw new APIException(404, -1, String.format("No se ha podido crear el departamento con datos %s", oBD));
        }
        return Response.status(Response.Status.CREATED).entity( oBD ).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(@PathParam("id") Integer id, GrupoDTO oDTO){
        GrupoDTO oBD = grupoEjbService.save(id, oDTO);

        if ( oBD == null || oBD.getId() == null ){
            throw new APIException(404, -1, String.format("No se ha podido actualizar el departamento con id %d, datos %s", id, oDTO));
        }
        return Response.ok().entity( oBD ).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response estadoCero(@PathParam("id") Integer id){
        Integer ok = grupoEjbService.estadoCero(id);

        if ( ok == 0 ){
            throw new APIException(404, -1, String.format("No se ha podido eliminar el grupo con id %d", id));
        }

        return Response.status(Response.Status.ACCEPTED).build();
    }

}

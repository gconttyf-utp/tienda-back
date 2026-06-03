package org.utp.web.back.apirest.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

import org.utp.web.back.apirest.exceptions.APIException;
import org.utp.web.back.apirest.models.dto.MarcaDTO;
import org.utp.web.back.ejb.services.MarcaEjbService;

@Path("/usuario/marcas")
public class MarcaController {

    @Inject
    private MarcaEjbService marcaEjbService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar(@QueryParam("estado") List<Integer> estadosQuery){
        List<Integer> estados = (estadosQuery == null || estadosQuery.isEmpty()) ? List.of(0, 1) : estadosQuery;

        List<MarcaDTO> listado = marcaEjbService.listado( estados );

        if (listado.isEmpty()){
            throw new APIException(404, -1, String.format("No hay marcas"));
        }
        return Response.ok().entity( listado ).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response encontrarId(@PathParam("id") Integer id){
        MarcaDTO oDTO = marcaEjbService.encontrarId(id);

        if (oDTO == null){
            throw new APIException(404, -1, String.format("No hay marca con el id %d", id));
        }
        return Response.ok().entity( oDTO ).build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response nuevo(MarcaDTO oDTO){
        MarcaDTO oBD = marcaEjbService.save(null, oDTO);

        if ( oBD.getId() == null ){
            throw new APIException(404, -1, String.format("No se ha podido crear la marca con datos %s", oBD));
        }
        return Response.status(Response.Status.CREATED).entity( oBD ).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(@PathParam("id") Integer id, MarcaDTO oDTO){
        MarcaDTO oBD = marcaEjbService.save(id, oDTO);

        if ( oBD == null || oBD.getId() == null ){
            throw new APIException(404, -1, String.format("No se ha podido actualizar la marca con id %d, datos %s", id, oDTO));
        }
        return Response.ok().entity( oBD ).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response estadoCero(@PathParam("id") Integer id){
        Integer ok = marcaEjbService.estadoCero(id);

        if ( ok == 0 ){
            throw new APIException(404, -1, String.format("No se ha podido eliminar la marca con id %d", id));
        }
        return Response.status(Response.Status.ACCEPTED).build();
    }

}

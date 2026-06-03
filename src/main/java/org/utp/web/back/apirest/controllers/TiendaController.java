package org.utp.web.back.apirest.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.utp.web.back.apirest.exceptions.APIException;
import org.utp.web.back.apirest.models.dto.TiendaDTO;
import org.utp.web.back.ejb.services.TiendaEjbService;

import java.util.List;

@Path("/usuario/tiendas")
public class TiendaController {

    @Inject
    private TiendaEjbService tiendaEjbService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar(@QueryParam("estado") List<Integer> estadosQuery){
        List<Integer> estados = (estadosQuery == null || estadosQuery.isEmpty()) ? List.of(0, 1) : estadosQuery;

        List<TiendaDTO> listado = tiendaEjbService.listado( estados );

        if (listado.isEmpty()){
            throw new APIException(404, -1, String.format("No hay tiendas"));
        }
        return Response.ok().entity( listado ).build();
    }

    @GET
    @Path("/ubigeo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarUbigeo(@QueryParam("codigo") String codUbigeo, @QueryParam("estado") List<Integer> estadosQuery){
        List<Integer> estados = (estadosQuery == null || estadosQuery.isEmpty()) ? List.of(0, 1) : estadosQuery;

        List<TiendaDTO> listado = tiendaEjbService.listadoUbigeo(codUbigeo, estados);

        if (listado.isEmpty()){
            throw new APIException(404, -1, String.format("No hay tiendas para el ubigeo %s", codUbigeo));
        }
        return Response.ok().entity( listado ).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response encontrarId(@PathParam("id") Integer id){
        TiendaDTO oDTO = tiendaEjbService.encontrarId(id);

        if (oDTO == null){
            throw new APIException(404, -1, String.format("No hay tienda con el id %d", id));
        }
        return Response.ok().entity( oDTO ).build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response nuevo(TiendaDTO oDTO){
        TiendaDTO oBD = tiendaEjbService.save(null, oDTO);

        if ( oBD.getId() == null ){
            throw new APIException(404, -1, String.format("No se ha podido crear la tienda con datos %s", oBD));
        }
        return Response.status(Response.Status.CREATED).entity( oBD ).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(@PathParam("id") Integer id, TiendaDTO oDTO){
        TiendaDTO oBD = tiendaEjbService.save(id, oDTO);

        if ( oBD == null || oBD.getId() == null ){
            throw new APIException(404, -1, String.format("No se ha podido actualizar la tienda con id %d, datos %s", id, oDTO));
        }
        return Response.ok().entity( oBD ).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response estadoCero(@PathParam("id") Integer id){
        Integer ok = tiendaEjbService.estadoCero(id);

        if ( ok == 0 ){
            throw new APIException(404, -1, String.format("No se ha podido eliminar la tienda con id %d", id));
        }
        return Response.status(Response.Status.ACCEPTED).build();
    }

}

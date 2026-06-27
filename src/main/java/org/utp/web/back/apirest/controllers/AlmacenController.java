package org.utp.web.back.apirest.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.utp.web.back.apirest.exceptions.APIException;
import org.utp.web.back.apirest.models.dto.AlmacenDTO;
import org.utp.web.back.apirest.models.dto.TiendaDTO;
import org.utp.web.back.ejb.services.AlmacenEjbService;

import java.util.List;

@Path("/usuario/almacenes")
public class AlmacenController {

    @Inject
    private AlmacenEjbService almacenEjbService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar(@QueryParam("tienda") Integer tienda){
        List<AlmacenDTO> listado = almacenEjbService.listado(tienda);

        if (listado.isEmpty()){
            throw new APIException(404, -1, String.format("No hay almacenes"));
        }
        return Response.ok().entity( listado ).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response encontrarId(@PathParam("id") Integer id){
        AlmacenDTO oDTO = almacenEjbService.encontrarId(id);

        if (oDTO == null){
            throw new APIException(404, -1, String.format("No hay almacen con el id %d", id));
        }
        return Response.ok().entity( oDTO ).build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response nuevo(AlmacenDTO oDTO){
        AlmacenDTO oBD = almacenEjbService.save(null, oDTO);

        if ( oBD.getId() == null ){
            throw new APIException(404, -1, String.format("No se ha podido crear el almacen con datos %s", oBD));
        }
        return Response.status(Response.Status.CREATED).entity( oBD ).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(@PathParam("id") Integer id, AlmacenDTO oDTO){
        AlmacenDTO oBD = almacenEjbService.save(id, oDTO);

        if ( oBD == null || oBD.getId() == null ){
            throw new APIException(404, -1, String.format("No se ha podido actualizar el almacen con id %d, datos %s", id, oDTO));
        }
        return Response.ok().entity( oBD ).build();
    }

    @GET
    @Path("/tiendas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTiendas(@QueryParam("activadas") Integer activadas){
        List<TiendaDTO> listado = null;

        if ( activadas == 0 ){
            listado = almacenEjbService.listadoTiendasSinAlmacen();
        } else if ( activadas == 1 ){
            listado = almacenEjbService.listadoTiendasConAlmacen();
        }

        if (listado.isEmpty() || listado == null){
            throw new APIException(404, -1, String.format("No hay tiendas"));
        }
        return Response.ok().entity( listado ).build();
    }

}

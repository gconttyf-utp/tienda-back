package org.utp.web.back.apirest.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.utp.web.back.apirest.exceptions.APIException;
import org.utp.web.back.apirest.models.dto.ClienteDTO;
import org.utp.web.back.ejb.services.ClienteEjbService;

import java.util.List;
import java.util.Map;

@Path("/usuario/clientes")
public class ClienteController {

    @Inject
    private ClienteEjbService clienteEjbService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar(@QueryParam("estado") List<Integer> estadosQuery){
        List<Integer> estados = (estadosQuery == null || estadosQuery.isEmpty()) ? List.of(0, 1) : estadosQuery;

        List<ClienteDTO> listado = clienteEjbService.listado(estados);

        if (listado.isEmpty()){
            throw new APIException(404, -1, String.format("No hay clientes"));
        }
        return Response.ok().entity( listado ).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response encontrarId(@PathParam("id") Integer id){
        ClienteDTO oDTO = clienteEjbService.encontrarId(id);

        if (oDTO == null){
            throw new APIException(404, -1, String.format("No hay cliente con el id %d", id));
        }
        return Response.ok().entity( oDTO ).build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response nuevo(ClienteDTO oDTO){
        ClienteDTO oBD = clienteEjbService.save(null, oDTO);

        if ( oBD.getId() == null ){
            throw new APIException(404, -1, String.format("No se ha podido crear el cliente con datos %s", oBD));
        }
        return Response.status(Response.Status.CREATED).entity( oBD ).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(@PathParam("id") Integer id, ClienteDTO oDTO){
        ClienteDTO oBD = clienteEjbService.save(id, oDTO);

        if ( oBD == null || oBD.getId() == null ){
            throw new APIException(404, -1, String.format("No se ha podido actualizar el cliente con id %d, datos %s", id, oDTO));
        }
        return Response.ok().entity( oBD ).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response estadoCero(@PathParam("id") Integer id){
        Integer ok = clienteEjbService.estadoCero(id);

        if ( ok == 0 ){
            throw new APIException(404, -1, String.format("No se ha podido eliminar el cliente con id %d", id));
        }
        return Response.status(Response.Status.ACCEPTED).build();
    }

    @PUT
    @Path("/newclave/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarClave(@PathParam("id") Integer id, Map<String, String> newClave){
        String newClaveLimpia = newClave.get("newClave");
        Integer ok = clienteEjbService.actualizarClave(id, newClaveLimpia);

        if ( ok == 0 ){
            throw new APIException(404, -1, String.format("No se ha podido actualizar la clave del usuario con id %d", id));
        }
        return Response.status(Response.Status.ACCEPTED).build();
    }

}

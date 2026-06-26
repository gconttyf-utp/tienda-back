package org.utp.web.back.apirest.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.utp.web.back.apirest.exceptions.APIException;
import org.utp.web.back.apirest.models.dto.UsuarioDTO;
import org.utp.web.back.ejb.services.UsuarioEjbService;

import java.util.List;
import java.util.Map;

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

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response encontrarId(@PathParam("id") Integer id){
        UsuarioDTO oDTO = usuarioEjbService.encontrarId(id);

        if (oDTO == null){
            throw new APIException(404, -1, String.format("No hay usuario con el id %d", id));
        }
        return Response.ok().entity( oDTO ).build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response nuevo(UsuarioDTO oDTO){
        UsuarioDTO oBD = usuarioEjbService.save(null, oDTO);

        if ( oBD.getId() == null ){
            throw new APIException(404, -1, String.format("No se ha podido crear el usuario con datos %s", oBD));
        }
        //return Response.ok( oBD ).build();
        //return Response.ok().entity( oBD ).build();
        /*return Response.ok()
                .header("X-Total-Count", "50") // Añades un header
                .entity(oBD)                   // Inyectas el cuerpo
                .build();*/
        return Response.status(Response.Status.CREATED).entity(oBD).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(@PathParam("id") Integer id, UsuarioDTO oDTO){
        UsuarioDTO oBD = usuarioEjbService.save(id, oDTO);

        if ( oBD == null || oBD.getId() == null ){
            throw new APIException(404, -1, String.format("No se ha podido actualizar el usuario con id %d, datos %s", id, oDTO));
        }
        return Response.ok().entity( oBD ).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response estadoCero(@PathParam("id") Integer id){
        Integer ok = usuarioEjbService.estadoCero(id);

        if ( ok == 0 ){
            throw new APIException(404, -1, String.format("No se ha podido eliminar el usuario con id %d", id));
        }

        //return Response.status(202).build();
        return Response.status(Response.Status.ACCEPTED).build();
    }

    @PUT
    @Path("/newclave/{id}")
    public Response actualizarClave(@PathParam("id") Integer id, Map<String, String> newClave){
        System.out.println("actualizarClave= " + newClave.get("newClave"));
        String newClaveLimpia = newClave.get("newClave");
        Integer ok = usuarioEjbService.actualizarClave(id, newClaveLimpia);

        if ( ok == 0 ){
            throw new APIException(404, -1, String.format("No se ha podido actualizar la clave del usuario con id %d", id));
        }
        //return Response.status(202).build();
        return Response.status(Response.Status.ACCEPTED).build();
    }

}

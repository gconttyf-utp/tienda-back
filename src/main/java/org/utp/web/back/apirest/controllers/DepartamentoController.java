package org.utp.web.back.apirest.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

import org.utp.web.back.apirest.exceptions.APIException;
import org.utp.web.back.apirest.models.dto.DepartamentoDTO;
import org.utp.web.back.ejb.services.DepartamentoEjbService;

@Path("/usuario/departamentos")
public class DepartamentoController {

    @Inject
    private DepartamentoEjbService departamentoEjbService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarDepartamentos(@QueryParam("estado") List<Integer> estadosQuery){
        List<Integer> estados = (estadosQuery == null || estadosQuery.isEmpty()) ? List.of(0, 1) : estadosQuery;

        List<DepartamentoDTO> listado = departamentoEjbService.listarDepartamentos(estados);

        if (listado.isEmpty()){
            throw new APIException(404, -1, String.format("No hay departamentos"));
        }
        return Response.ok().entity( listado ).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response encDepartamento(@PathParam("id") Integer id){
        DepartamentoDTO oDTO = departamentoEjbService.encontrarDepartamento(id);

        if (oDTO == null){
            throw new APIException(404, -1, String.format("No hay departamento con el id %d", id));
        }
        return Response.ok().entity( oDTO ).build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvarDepartamento(DepartamentoDTO departamentoDTO){
        DepartamentoDTO oDTO = departamentoEjbService.salvarDepartamento(null, departamentoDTO);

        if ( oDTO.getId() == null ){
            throw new APIException(404, -1, String.format("No se ha podido crear el departamento con datos %s", departamentoDTO));
        }
        return Response.status(Response.Status.CREATED).entity( oDTO ).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarDepartamento(@PathParam("id") Integer id, DepartamentoDTO departamentoDTO){
        DepartamentoDTO oBD = departamentoEjbService.salvarDepartamento(id, departamentoDTO);

        if ( oBD == null || oBD.getId() == null ){
            throw new APIException(404, -1, String.format("No se ha podido actualizar el departamento con id %d, datos %s", id, departamentoDTO));
        }
        return Response.ok().entity( oBD ).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminarDepartamento(@PathParam("id") Integer id){
        Integer ok = departamentoEjbService.eliminarDepartamento(id);

        if ( ok == 0 ){
            throw new APIException(404, -1, String.format("No se ha podido eliminar el departamento con id %d", id));
        }
        return Response.status(Response.Status.ACCEPTED).build();
    }

}

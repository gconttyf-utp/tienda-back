package org.utp.web.back.apirest.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.utp.web.back.apirest.exceptions.APIException;
import org.utp.web.back.apirest.models.dto.ReclamoDTO;
import org.utp.web.back.ejb.services.ReclamoEjbService;

import java.util.List;

// La ruta acepta un parámetro "tipo" que estrictamente debe ser "usuario" o "cliente"
@Path("/{tipo : usuario|cliente}/reclamos")
public class ReclamoController {

    @Inject
    private ReclamoEjbService reclamoEjbService;

    @GET
    @Path("/pruebareclamos")
    public Response obtenerReclamos2(@PathParam("tipo") String tipo) {

        // Opcional: Puedes usar la variable 'tipo' si necesitas lógica diferente
        if ("usuario".equals(tipo)) {
            System.out.println("Petición desde la ruta de usuario");
        } else if ("cliente".equals(tipo)) {
            System.out.println("Petición desde la ruta de cliente");
        }

        return Response.ok("Lista de reclamos para: " + tipo).build();
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerReclamos(@PathParam("tipo") String tipo) {

        // Opcional: Puedes usar la variable 'tipo' si necesitas lógica diferente
        if ("usuario".equals(tipo)) {
            System.out.println("Petición desde la ruta de usuario");
        } else if ("cliente".equals(tipo)) {
            System.out.println("Petición desde la ruta de cliente");
        }

        List<ReclamoDTO> listado = reclamoEjbService.listarTodos();

        return Response.ok().entity( listado ).build();
    }

    @GET
    @Path("/cliente")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerReclamosPorCliente(@PathParam("tipo") String tipo, @QueryParam("id") Integer clienteId) {

        // Opcional: Puedes usar la variable 'tipo' si necesitas lógica diferente
        if ("usuario".equals(tipo)) {
            System.out.println("Petición desde la ruta de usuario");
        } else if ("cliente".equals(tipo)) {
            System.out.println("Petición desde la ruta de cliente");
        }

        List<ReclamoDTO> listado = reclamoEjbService.listarPorCliente(clienteId);

        return Response.ok().entity( listado ).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response encontrarId(@PathParam("tipo") String tipo, @PathParam("id") Integer id){
        // Opcional: Puedes usar la variable 'tipo' si necesitas lógica diferente
        if ("usuario".equals(tipo)) {
            System.out.println("Petición desde la ruta de usuario");
        } else if ("cliente".equals(tipo)) {
            System.out.println("Petición desde la ruta de cliente");
        }

        ReclamoDTO oDTO = reclamoEjbService.encontrarID(id);

        if (oDTO == null){
            throw new APIException(404, -1, String.format("No hay reclamo con el id %d", id));
        }
        return Response.ok().entity( oDTO ).build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response nuevo(@PathParam("tipo") String tipo, ReclamoDTO oDTO) {

        // Opcional: Puedes usar la variable 'tipo' si necesitas lógica diferente
        if ("usuario".equals(tipo)) {
            System.out.println("Petición desde la ruta de usuario");
        } else if ("cliente".equals(tipo)) {
            System.out.println("Petición desde la ruta de cliente");
        }

        ReclamoDTO oBD = reclamoEjbService.save(0, oDTO);

        if ( oBD.getId() == null ){
            throw new APIException(404, -1, String.format("No se ha podido crear el producto con datos %s", oBD));
        }

        return Response.status(Response.Status.CREATED).entity( oBD ).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(@PathParam("tipo") String tipo, @PathParam("id") Integer id, ReclamoDTO oDTO){
        // Opcional: Puedes usar la variable 'tipo' si necesitas lógica diferente
        if ("usuario".equals(tipo)) {
            System.out.println("Petición desde la ruta de usuario");
        } else if ("cliente".equals(tipo)) {
            System.out.println("Petición desde la ruta de cliente");
        }

        ReclamoDTO oBD = reclamoEjbService.save(id, oDTO);

        if (oBD == null || oBD.getId() == null ){
            throw new APIException(404, -1, String.format("No hay reclamo con el id %d", id));
        }
        return Response.ok().entity( oBD ).build();
    }

}

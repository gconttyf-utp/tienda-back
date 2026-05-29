package org.utp.web.back.apirest.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

import org.utp.web.back.ejb.services.MarcaEjbService;

@Path("/marca")
public class MarcaController {

    @Inject
    private MarcaEjbService marcaEjbService;

    @GET
    @Path("/listado")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar(@QueryParam("estado") List<Integer> estados){
        System.out.println("marca.listar()");
        return Response.ok().entity(marcaEjbService.listado(estados)).build();
    }
}

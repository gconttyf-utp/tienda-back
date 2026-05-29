package org.utp.web.back.apirest.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

import org.utp.web.back.apirest.services.CategoriaService;

@Path("/categoria")
public class CategoriaController {

    @Inject
    private CategoriaService service;

    @GET
    @Path("/listadoporgrupo/{grupo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar(@PathParam("grupo") Integer grupo, @QueryParam("estado") List<Integer> estados){
        System.out.println("categoria.listar()");
        return Response.ok().entity(service.listarCategoriaPorGrupo(grupo, estados)).build();
    }
}

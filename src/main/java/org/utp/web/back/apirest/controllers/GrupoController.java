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

import org.utp.web.back.apirest.services.GrupoService;

@Path("/grupo")
public class GrupoController {

    @Inject
    private GrupoService service;

    @GET
    @Path("/listadopordepar/{depa}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar(@PathParam("depa") Integer depa, @QueryParam("estado") List<Integer> estados){
        System.out.println("grupo.listar()");
        return Response.ok().entity(service.listarGrupos(depa, estados)).build();
    }
}

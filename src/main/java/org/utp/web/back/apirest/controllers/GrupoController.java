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

import org.utp.web.back.ejb.services.GrupoEjbService;

@Path("/grupo")
public class GrupoController {

    @Inject
    private GrupoEjbService grupoEjbService;

    @GET
    @Path("/listadopordepar/{depa}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar(@PathParam("depa") Integer depa, @QueryParam("estado") List<Integer> estados){
        System.out.println("grupo.listar()");
        return Response.ok().entity(grupoEjbService.listado(depa, estados)).build();
    }
}

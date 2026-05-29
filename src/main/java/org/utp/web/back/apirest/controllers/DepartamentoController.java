package org.utp.web.back.apirest.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

import org.utp.web.back.ejb.services.DepartamentoEjbService;

@Path("/usuario/departamento")
public class DepartamentoController {

    @Inject
    private DepartamentoEjbService ejbService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar(){
        System.out.println("departamento.listar()");
        return Response.ok().entity(ejbService.listarDepartamentos(List.of(1))).build();
    }

}

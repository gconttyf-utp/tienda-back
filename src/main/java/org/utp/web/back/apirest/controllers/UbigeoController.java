package org.utp.web.back.apirest.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.utp.web.back.apirest.services.UbigeoService;

@Path("/ubigeo")
public class UbigeoController {

    @Inject
    private UbigeoService service;

    @GET
    @Path("/departamentos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar(){
        System.out.println("Ubigeo.listar()");
        return Response.ok().entity(service.listarDepartamentos()).build();
    }

    @GET
    @Path("/provinciasdistritos/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarProvinciasDistritos(@PathParam("codigo") String codigo){
        System.out.println("Ubigeo.listarPronvinciasDistritos()");
        return Response.ok().entity(service.listarProvinciasDistritos(codigo)).build();
    }

    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response encUbigeo(@PathParam("codigo") String codigo){
        System.out.println("Ubigeo.encUbigeo()");
        return Response.ok().entity(service.buscarUbigeo(codigo)).build();
    }

}

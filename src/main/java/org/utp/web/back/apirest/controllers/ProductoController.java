package org.utp.web.back.apirest.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

import org.utp.web.back.apirest.services.ProductoService;

@Path("/producto")
public class ProductoController {

    @Inject
    private ProductoService service;

    @GET
    @Path("/listadoporcategoria/{categoria}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar(@PathParam("categoria") Integer categoria){
        System.out.println("producto.listarporcategoria()");
        return Response.ok().entity(service.listarProductosPorCategoria(categoria, List.of(1))).build();
    }

    @GET
    @Path("/listadoporcategoriaymarca")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar2(@QueryParam("categoriaID") Integer categoriaID, @QueryParam("marcaID") Integer marcaID){
        System.out.println("producto.listadoporcategoriaymarca()");
        return Response.ok().entity( service.listarProductoPorCategoriaAndMarca(categoriaID, marcaID, List.of(1)) ).build();
    }

    @GET
    @Path("/productos/marca")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarProductos3(@QueryParam("codigo") Integer codMarca){
        return Response.ok().entity(service.listarProductoPorMarca(codMarca, List.of(1))).build();
    }
}

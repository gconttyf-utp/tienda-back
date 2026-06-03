package org.utp.web.back.apirest.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

import org.utp.web.back.apirest.exceptions.APIException;
import org.utp.web.back.apirest.models.dto.ProductoDTO;
import org.utp.web.back.ejb.services.ProductoEjbService;

@Path("/usuario/productos")
public class ProductoController {

    @Inject
    private ProductoEjbService productoEjbService;

    @GET
    @Path("/categoria")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarProductosCategoria(
            @QueryParam("codigo") Integer codCategoria,
            @QueryParam("estado") List<Integer> estadosQuery){
        List<Integer> estados = (estadosQuery == null || estadosQuery.isEmpty()) ? List.of(0, 1) : estadosQuery;

        List<ProductoDTO> listarProductos = productoEjbService.listarProductosPorCategoria(codCategoria, estados);

        if (listarProductos.isEmpty()){
            throw new APIException(404, -1, String.format("No hay productos para la categoria %d", codCategoria));
        }
        return Response.ok().entity( listarProductos ).build();
    }

    @GET
    @Path("/marca")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarProductosMarca(
            @QueryParam("codigo") Integer codMarca,
            @QueryParam("estado") List<Integer> estadosQuery){
        List<Integer> estados = (estadosQuery == null || estadosQuery.isEmpty()) ? List.of(0, 1) : estadosQuery;

        List<ProductoDTO> listarProductos = productoEjbService.listarProductosPorMarca(codMarca, estados);

        if (listarProductos.isEmpty()){
            throw new APIException(404, -1, String.format("No hay productos para la marca %d", codMarca));
        }
        return Response.ok().entity( listarProductos ).build();
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarProductosCategoriaMarca(
            @QueryParam("categoria") Integer codCategoria,
            @QueryParam("marca") Integer codMarca,
            @QueryParam("estado") List<Integer> estadosQuery){
        List<Integer> estados = (estadosQuery == null || estadosQuery.isEmpty()) ? List.of(0, 1) : estadosQuery;

        List<ProductoDTO> listarProductos = productoEjbService.listarProductosPorCategoriaAndMarca(codCategoria, codMarca, estados);

        if (listarProductos.isEmpty()){
            throw new APIException(404, -1, String.format("No hay productos para la categoria %d y la marca %d", codCategoria, codMarca));
        }
        return Response.ok().entity( listarProductos ).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response encontrarId(@PathParam("id") Integer id){
        ProductoDTO oDTO = productoEjbService.encontrarId(id);

        if (oDTO == null){
            throw new APIException(404, -1, String.format("No hay producto con el id %d", id));
        }
        return Response.ok().entity( oDTO ).build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response nuevo(ProductoDTO oDTO){
        ProductoDTO oBD = productoEjbService.save(null, oDTO);

        if ( oBD.getId() == null ){
            throw new APIException(404, -1, String.format("No se ha podido crear el producto con datos %s", oBD));
        }
        return Response.status(Response.Status.CREATED).entity( oBD ).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(@PathParam("id") Integer id, ProductoDTO oDTO){
        ProductoDTO oBD = productoEjbService.save(id, oDTO);

        if ( oBD == null || oBD.getId() == null ){
            throw new APIException(404, -1, String.format("No se ha podido actualizar el producto con id %d, datos %s", id, oDTO));
        }
        return Response.ok().entity( oBD ).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response estadoCero(@PathParam("id") Integer id){
        Integer ok = productoEjbService.estadoCero(id);

        if ( ok == 0 ){
            throw new APIException(404, -1, String.format("No se ha podido eliminar el producto con id %d", id));
        }
        return Response.status(Response.Status.ACCEPTED).build();
    }

}

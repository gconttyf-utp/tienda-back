package org.utp.web.back.apirest.controllers;

import java.util.List;

import org.utp.web.back.apirest.services.CategoriaService;
import org.utp.web.back.apirest.services.DepartamentoService;
import org.utp.web.back.apirest.services.GrupoService;
import org.utp.web.back.apirest.services.MarcaService;
import org.utp.web.back.apirest.services.ProductoService;
import org.utp.web.back.apirest.services.TiendaService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/publico")
public class PublicoController {

    @Inject
    private DepartamentoService serviceDepartamento;

    @Inject
    private GrupoService serviceGrupo;

    @Inject
    private CategoriaService serviceCategoria;

    @Inject
    private MarcaService serviceMarca;

    @Inject
    private ProductoService serviceProducto;

    @Inject
    private TiendaService serviceTienda;

    @GET
    @Path("/{ruta: departamento|departamentos}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarDepartamentos(){
        return Response.ok().entity(serviceDepartamento.listarDepartamentos(List.of(1))).build();
    }

    @GET
    @Path("/grupos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarGrupos(@QueryParam("depa") Integer depa){
        System.out.println("grupo.listar()");
        return Response.ok().entity(serviceGrupo.listarGrupos(depa, List.of(1))).build();
    }

    @GET
    @Path("/categorias")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarCategorias(@QueryParam("grupo") Integer grupo){
        System.out.println("categoria.listar()");
        return Response.ok().entity(serviceCategoria.listarCategoriaPorGrupo(grupo, List.of(1))).build();
    }

    @GET
    @Path("/marcas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarMarcas(){
        System.out.println("marca.listar()");
        return Response.ok().entity(serviceMarca.listarMarca(List.of(1))).build();
    }

    @GET
    @Path("/productos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarProductos(@QueryParam("categoria") Integer categoriaID, @QueryParam("marca") Integer marcaID){
        System.out.println("producto.listadoporcategoriaymarca()");
        System.out.println(serviceProducto.listarProductoPorCategoriaAndMarca(categoriaID, marcaID, List.of(1)));
        return Response.ok().entity( serviceProducto.listarProductoPorCategoriaAndMarca(categoriaID, marcaID, List.of(1)) ).build();
    }

    @GET
    @Path("/productos/categoria")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarProductos2(@QueryParam("codigo") Integer categoria){
        System.out.println("producto.listarporcategoria()");
        return Response.ok().entity(serviceProducto.listarProductosPorCategoria(categoria, List.of(1))).build();
    }

    @GET
    @Path("/productos/marca")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarProductos3(@QueryParam("codigo") Integer codMarca){
        return Response.ok().entity(serviceProducto.listarProductoPorMarca(codMarca, List.of(1))).build();
    }

    @GET
    @Path("/producto/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response encontrarProducto(@PathParam("id") Integer id){
        return Response.ok().entity(serviceProducto.encontrarProducto(id)).build();
    }

    @GET
    @Path("/tiendas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTiendas(){
        return Response.ok().entity(serviceTienda.listarTiendas(List.of(1))).build();
    }

    @GET
    @Path("/tiendasubigeo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTiendasUbigeo(@QueryParam("ubigeo") String codUbigeo){
        return Response.ok().entity(serviceTienda.listarTiendasUbigeo(codUbigeo, List.of(1))).build();
    }

}

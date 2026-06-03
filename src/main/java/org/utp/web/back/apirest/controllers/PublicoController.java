package org.utp.web.back.apirest.controllers;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.utp.web.back.apirest.exceptions.APIException;
import org.utp.web.back.apirest.models.dto.*;
import org.utp.web.back.ejb.services.*;

@Path("/publico")
public class PublicoController {

    @Inject
    private DepartamentoEjbService departamentoEjbService;

    @Inject
    private GrupoEjbService grupoEjbService;

    @Inject
    private CategoriaEjbService categoriaEjbService;

    @Inject
    private MarcaEjbService marcaEjbService;

    @Inject
    private ProductoEjbService productoEjbService;

    @Inject
    private TiendaEjbService tiendaEjbService;

    @GET
    @Path("/{ruta: departamento|departamentos}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarDepartamentos(){
        List<DepartamentoDTO> listarDepartamentos = departamentoEjbService.listarDepartamentos(List.of(1));
        if (listarDepartamentos.isEmpty()){
            throw new APIException(404, -1, String.format("No hay departamentos"));
        }
        return Response.ok().entity( listarDepartamentos ).build();
    }

    @GET
    @Path("/grupos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarGrupos(@QueryParam("depa") Integer depa){
        System.out.println("grupo.listar()");
        List<GrupoDTO> listarGrupos = grupoEjbService.listado(depa, List.of(1));
        if (listarGrupos.isEmpty()){
            throw new APIException(404, -1, String.format("No hay grupos para el departamento %d", depa));
        }
        return Response.ok().entity( listarGrupos ).build();
    }

    @GET
    @Path("/categorias")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarCategorias(@QueryParam("grupo") Integer grupo){
        System.out.println("categoria.listar()");
        List<CategoriaDTO> listarCategorias = categoriaEjbService.listarCategoriaPorGrupo(grupo, List.of(1));
        if (listarCategorias.isEmpty()){
            throw new APIException(404, -1, String.format("No hay categorias para el grupo %d", grupo));
        }
        return Response.ok().entity( listarCategorias ).build();
    }

    @GET
    @Path("/marcas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarMarcas(){
        System.out.println("marca.listar()");
        List<MarcaDTO> listarMarcas = marcaEjbService.listado(List.of(1));
        if (listarMarcas.isEmpty()){
            throw new APIException(404, -1, String.format("No hay Marcas"));
        }
        return Response.ok().entity( listarMarcas ).build();
    }

    @GET
    @Path("/productos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarProductos(@QueryParam("categoria") Integer categoriaID, @QueryParam("marca") Integer marcaID){
        System.out.println("producto.listadoporcategoriaymarca()");
        List<ProductoDTO> listarProductos = productoEjbService.listarProductosPorCategoriaAndMarca(categoriaID, marcaID, List.of(1));
        if (listarProductos.isEmpty()){
            throw new APIException(404, -1, String.format("No hay productos para la categoria %d y la marca %d", categoriaID, marcaID));
        }
        return Response.ok().entity( listarProductos ).build();
    }

    @GET
    @Path("/productos/categoria")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarProductos2(@QueryParam("codigo") Integer categoria){
        System.out.println("producto.listarporcategoria()");
        List<ProductoDTO> listarProductos = productoEjbService.listarProductosPorCategoria(categoria, List.of(1));
        if (listarProductos.isEmpty()){
            throw new APIException(404, -1, String.format("No hay productos para la categoria %d", categoria));
        }
        return Response.ok().entity( listarProductos ).build();
    }

    @GET
    @Path("/productos/marca")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarProductos3(@QueryParam("codigo") Integer codMarca){
        List<ProductoDTO> listarProductos = productoEjbService.listarProductosPorMarca(codMarca, List.of(1));
        if (listarProductos.isEmpty()){
            throw new APIException(404, -1, String.format("No hay productos para la marca %d", codMarca));
        }
        return Response.ok().entity( listarProductos ).build();
    }

    @GET
    @Path("/producto/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response encontrarProducto(@PathParam("id") Integer id){
        ProductoDTO producto = productoEjbService.encontrarId(id);
        if (producto == null){
            throw new APIException(404, -1, String.format("No hay producto con el ID %d", id));
        }
        return Response.ok().entity( producto ).build();
    }

    @GET
    @Path("/tiendas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTiendas(){
        List<TiendaDTO> listarTiendas = tiendaEjbService.listado(List.of(1));
        if (listarTiendas.isEmpty()){
            throw new APIException(404, -1, String.format("No hay tiendas"));
        }
        return Response.ok().entity( listarTiendas ).build();
    }

    @GET
    @Path("/tiendasubigeo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTiendasUbigeo(@QueryParam("ubigeo") String codUbigeo){
        List<TiendaDTO> listarTiendas = tiendaEjbService.listadoUbigeo(codUbigeo, List.of(1));
        if (listarTiendas.isEmpty()){
            throw new APIException(404, -1, String.format("No hay tiendas para el ubigeo %s", codUbigeo));
        }
        return Response.ok().entity( listarTiendas ).build();
    }

    @GET
    @Path("/ofertadepartamento")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarOfertaDepartamento(@QueryParam("codigo") Integer codDepartamento){
        List<GrupoDTO> listarGrupos = grupoEjbService.listado(codDepartamento, List.of(1));
        if (!listarGrupos.isEmpty()){
            List<Integer> grupos = listarGrupos.stream().map(GrupoDTO::getId).toList();

            List<CategoriaDTO> listarCategorias = categoriaEjbService.listadoxGrupos(grupos, List.of(1));
            if (!listarCategorias.isEmpty()){
                List<Integer> categorias = listarCategorias.stream().map(CategoriaDTO::getId).toList();

                List<ProductoDTO> listarProductos = productoEjbService.listarProductosOfertaDepartamento(categorias, List.of(1), List.of(1));
                if (!listarProductos.isEmpty()){
                    return Response.ok().entity(listarProductos).build();
                }
            }
        }
        throw new APIException(404, -1, String.format("No hay ofertas por departamento %d", codDepartamento));
    }

    @GET
    @Path("/ofertagrupos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarOfertaGrupos(@QueryParam("codigo") Integer codGrupo,
                                       @QueryParam("oferta") List<Integer> ofertas){
        List<CategoriaDTO> listarCategorias = categoriaEjbService.listadoxGrupos(List.of(codGrupo), List.of(1));
        if (!listarCategorias.isEmpty()){
            List<Integer> categorias = listarCategorias.stream().map(CategoriaDTO::getId).toList();

            List<ProductoDTO> listarProductos = null;
            if ( ofertas == null || ofertas.isEmpty() ){
                listarProductos = productoEjbService.listarProductosOfertaDepartamento(categorias, List.of(1), List.of(1));
            } else {
                listarProductos = productoEjbService.listarProductosOfertaDepartamento(categorias, ofertas, List.of(1));
            }

            if (!listarProductos.isEmpty()){
                return Response.ok().entity(listarProductos).build();
            }
        }
        throw new APIException(404, -1, String.format("No hay ofertas por grupo %d", codGrupo));
    }

    @GET
    @Path("/ofertas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarOfertas(){
        List<ProductoDTO> listarProductos = productoEjbService.listarProductosOfertas(List.of(1), List.of(1));
        if (!listarProductos.isEmpty()){
            return Response.ok().entity(listarProductos).build();
        }
        throw new APIException(404, -1, String.format("No hay ofertas"));
    }

}

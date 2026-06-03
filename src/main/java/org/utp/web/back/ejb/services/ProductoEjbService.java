package org.utp.web.back.ejb.services;

import java.util.List;

import jakarta.ejb.Local;
import org.utp.web.back.apirest.models.dto.ProductoDTO;
import org.utp.web.back.ejb.entities.Producto;

@Local
public interface ProductoEjbService {

    List<Producto> listarPorIdCategoria(Integer idCategoria);

    List<Producto> listarPorIdCategoriaAndMarca(Integer idCategoria, Integer idMarca);

    Producto buscarProducto(Integer id);

    List<ProductoDTO> listarProductosPorCategoria(Integer categoria, List<Integer> estados);

    List<ProductoDTO> listarProductosPorMarca(Integer marca, List<Integer> estados);

    List<ProductoDTO> listarProductosPorCategoriaAndMarca(Integer categoria, Integer marca, List<Integer> estados);

    ProductoDTO encontrarId(Integer id);

    Producto save(Integer id, Producto oDTO);

    Integer estadoCero(Integer id);

    List<ProductoDTO> listarProductosOfertaDepartamento(List<Integer> categorias, List<Integer> ofertas, List<Integer> estados);

    List<ProductoDTO> listarProductosOfertas(List<Integer> ofertas, List<Integer> estados);

}

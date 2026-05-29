package org.utp.web.back.ejb.services;

import java.util.List;

import org.utp.web.back.ejb.entities.Producto;

import jakarta.ejb.Remote;

@Remote
public interface ProductoEjbService {

    List<Producto> listarPorIdCategoria(Integer idCategoria);

    List<Producto> listarPorIdCategoriaAndMarca(Integer idCategoria, Integer idMarca);

    Producto buscarProducto(Integer id);

    List<Producto> listarProductosPorCategoria(Integer categoria, List<Integer> estados);

    List<Producto> listarProductosPorMarca(Integer marca, List<Integer> estados);

    List<Producto> listarProductosPorCategoriaAndMarca(Integer categoria, Integer marca, List<Integer> estados);

    Producto encontrarId(Integer id);

    Producto save(Integer id, Producto oDTO);

    Integer estadoCero(Integer id);

}

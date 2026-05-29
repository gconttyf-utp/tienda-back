package org.utp.web.back.apirest.services;

import org.utp.web.back.apirest.models.dto.ProductoDTO;

import java.util.List;

public interface ProductoService {

    List<ProductoDTO> listarProductosPorCategoria(Integer categoriaID, List<Integer> estados);

    List<ProductoDTO> listarProductoPorCategoriaAndMarca(Integer categoriaID, Integer marcaID, List<Integer> estados);

    List<ProductoDTO> listarProductoPorMarca(Integer marcaID, List<Integer> estados);

    ProductoDTO encontrarProducto(Integer id);
    
}

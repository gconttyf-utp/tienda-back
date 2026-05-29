package org.utp.web.back.apirest.services;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import org.utp.web.back.ejb.services.ProductoEjbService;
import org.utp.web.back.apirest.models.dto.ProductoDTO;
import org.utp.web.back.apirest.models.mappers.ProductoMapper;

import java.util.List;

@RequestScoped
public class ProductoServiceImpl implements ProductoService {

    @Inject
    private ProductoEjbService service;

    @Inject
    private ProductoMapper mapper;

    @Override
    public List<ProductoDTO> listarProductosPorCategoria(Integer categoriaID, List<Integer> estados) {
        return mapper.toDTOList( service.listarProductosPorCategoria(categoriaID, estados) );
    }

    @Override
    public List<ProductoDTO> listarProductoPorCategoriaAndMarca(Integer categoriaID, Integer marcaID, List<Integer> estados) {
        return mapper.toDTOList( service.listarProductosPorCategoriaAndMarca( categoriaID, marcaID, estados) );
    }

    @Override
    public List<ProductoDTO> listarProductoPorMarca(Integer marcaID, List<Integer> estados) {
        return mapper.toDTOList( service.listarProductosPorMarca( marcaID, estados ) );
    }

    @Override
    public ProductoDTO encontrarProducto(Integer id) {
        return mapper.toDTO( service.encontrarId(id) );
    }
}

package org.utp.web.back.ejb.services;

import java.util.List;

import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import org.utp.web.back.apirest.models.dto.ProductoDTO;
import org.utp.web.back.apirest.models.mappers.ProductoMapper;
import org.utp.web.back.ejb.entities.Producto;
import org.utp.web.back.ejb.repositories.ProductoRepository;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ProductoEjbServiceImpl implements ProductoEjbService {

    @Inject
    private ProductoRepository repository;

    @Inject
    private ProductoMapper mapper;

    @Override
    public List<Producto> listarPorIdCategoria(Integer idCategoria) {
        return repository.listarPorIdCategoria(idCategoria);
    }

    @Override
    public List<Producto> listarPorIdCategoriaAndMarca(Integer idCategoria, Integer idMarca) {
        return repository.listarPorIdCategoriaAndMarca(idCategoria, idMarca);
    }

    @Override
    public Producto buscarProducto(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<ProductoDTO> listarProductosPorCategoria(Integer categoria, List<Integer> estados) {
        return mapper.toDTOList( repository.findByCategoriaIdAndEstadoIn(categoria, estados) );
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<ProductoDTO> listarProductosPorMarca(Integer marca, List<Integer> estados) {
        return mapper.toDTOList( repository.findByMarcaIdAndEstadoIn(marca, estados) );
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<ProductoDTO> listarProductosPorCategoriaAndMarca(Integer categoria, Integer marca, List<Integer> estados) {
        return mapper.toDTOList( repository.findByCategoriaIdAndMarcaIdAndEstadoIn(categoria, marca, estados) );
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public ProductoDTO encontrarId(Integer id) {
        return mapper.toDTO( repository.findById(id).orElse(null) );
    }

    @Override
    public ProductoDTO save(Integer id, ProductoDTO oDTO) {
        if ( id == null || id == 0){
            return mapper.toDTO( repository.insertar( mapper.toEntity( oDTO ) ) );
        } else {
            ProductoDTO oBD = mapper.toDTO( repository.findById(id).orElse(null) );
            if ( oBD != null ){
                oBD.setCategoriaID( oDTO.getCategoriaID() );
                oBD.setMarcaID( oDTO.getMarcaID() );
                oBD.setDescripcion(oDTO.getDescripcion());
                oBD.setSku(oDTO.getSku());
                oBD.setPrecioLista(oDTO.getPrecioLista());
                oBD.setPrecioOnline(oDTO.getPrecioOnline());
                oBD.setStock(oDTO.getStock());
                oBD.setRutaImg(oDTO.getRutaImg());
                oBD.setEstado(oDTO.getEstado());
                return mapper.toDTO( repository.actualizar( mapper.toEntity( oBD ) ) );
            }
            return null;
        }
    }

    @Override
    public Integer estadoCero(Integer id) {
        Producto oBD = repository.findById(id).orElse(null);

        if ( oBD != null ) {
            //repository.deleteById(oBD.getId());
            oBD.setEstado(0);
            repository.actualizar(oBD);
            return 1;
        }
        return 0;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<ProductoDTO> listarProductosOfertaDepartamento(List<Integer> categorias, List<Integer> ofertas, List<Integer> estados) {
        return mapper.toDTOList( repository.findByCategoriaIdInAndOfertaInAndEstadoIn(categorias, ofertas, estados) );
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<ProductoDTO> listarProductosOfertas(List<Integer> ofertas, List<Integer> estados) {
        return mapper.toDTOList( repository.findByOfertaInAndEstadoIn(ofertas, estados) );
    }

}

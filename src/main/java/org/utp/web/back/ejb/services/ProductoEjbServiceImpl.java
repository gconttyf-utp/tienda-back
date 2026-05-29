package org.utp.web.back.ejb.services;

import java.util.List;

import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import org.utp.web.back.ejb.entities.Producto;
import org.utp.web.back.ejb.repositories.ProductoRepository;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ProductoEjbServiceImpl implements ProductoEjbService {

    @Inject
    private ProductoRepository repository;

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
    public List<Producto> listarProductosPorCategoria(Integer categoria, List<Integer> estados) {
        return repository.findByCategoriaIdAndEstadoIn(categoria, estados);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Producto> listarProductosPorMarca(Integer marca, List<Integer> estados) {
        return repository.findByMarcaIdAndEstadoIn(marca, estados);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Producto> listarProductosPorCategoriaAndMarca(Integer categoria, Integer marca, List<Integer> estados) {
        return repository.findByCategoriaIdAndMarcaIdAndEstadoIn(categoria, marca, estados);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Producto encontrarId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Producto save(Integer id, Producto oDTO) {
        if ( id == null || id == 0){
            return repository.insertar(oDTO);
        } else {
            Producto oBD = repository.findById(id).orElse(null);
            if ( oBD != null ){
                oBD.setCategoria(oDTO.getCategoria());
                oBD.setMarca(oDTO.getMarca());
                oBD.setDescripcion(oDTO.getDescripcion());
                oBD.setSku(oDTO.getSku());
                oBD.setPrecioLista(oDTO.getPrecioLista());
                oBD.setPrecioOnline(oDTO.getPrecioOnline());
                oBD.setStock(oDTO.getStock());
                oBD.setRutaImg(oDTO.getRutaImg());
                oBD.setEstado(oDTO.getEstado());
                return repository.actualizar(oBD);
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

}

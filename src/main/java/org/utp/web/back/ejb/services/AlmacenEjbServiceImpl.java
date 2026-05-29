package org.utp.web.back.ejb.services;

import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.inject.Inject;
import org.utp.web.back.ejb.entities.Almacen;
import org.utp.web.back.ejb.repositories.AlmacenRepository;
import org.utp.web.back.ejb.repositories.TiendaRepository;

import java.util.List;

@Stateless
public class AlmacenEjbServiceImpl implements AlmacenEjbService {

    @Inject
    private AlmacenRepository repository;

    @Inject
    private TiendaRepository tiendaRepository;

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Almacen> listado(Integer tienda) {
        return repository.listarPorIdTienda(tienda);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Almacen encontrarId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Almacen save(Integer id, Almacen oDTO) {
        if ( id == null || id == 0){
            return repository.insertar(oDTO);
        } else {
            Almacen oBD = repository.findById(id).orElse(null);
            if ( oBD != null ){
                oBD.setTienda(oDTO.getTienda());
                oBD.setProducto(oDTO.getProducto());
                oBD.setFechaIngreso(oDTO.getFechaIngreso());
                oBD.setCantidad(oDTO.getCantidad());
                return repository.actualizar(oBD);
            }
            return null;
        }
    }

}

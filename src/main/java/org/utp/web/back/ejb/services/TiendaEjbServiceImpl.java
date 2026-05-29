package org.utp.web.back.ejb.services;

import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.inject.Inject;
import org.utp.web.back.ejb.entities.Tienda;
import org.utp.web.back.ejb.repositories.TiendaRepository;

import java.util.List;

@Stateless
public class TiendaEjbServiceImpl implements TiendaEjbService {

    @Inject
    private TiendaRepository repository;

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Tienda> listado(List<Integer> estados) {
        return repository.findByEstadoIn(estados);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Tienda> listadoUbigeo(String ubigeo, List<Integer> estados) {
        return repository.findByUbigeoCodUbigeoAndEstadoIn(ubigeo, estados);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Tienda encontrarId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Tienda save(Integer id, Tienda oDTO) {
        if ( id == null || id == 0){
            return repository.insertar(oDTO);
        } else {
            Tienda oBD = repository.findById(id).orElse(null);

            if ( oBD != null ){
                oBD.setNombre(oDTO.getNombre());
                oBD.setDireccion(oDTO.getDireccion());
                oBD.setUbigeo(oDTO.getUbigeo());
                oBD.setEstado(oDTO.getEstado());
                return repository.actualizar(oBD);
            }
            return null;
        }
    }

    @Override
    public Integer estadoCero(Integer id) {
        Tienda oBD = repository.findById(id).orElse(null);

        if ( oBD != null ) {
            //repository.deleteById(oBD.getId());
            oBD.setEstado(0);
            repository.actualizar(oBD);
            return 1;
        }
        return 0;
    }

}

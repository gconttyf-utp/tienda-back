package org.utp.web.back.ejb.services;

import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.inject.Inject;
import org.utp.web.back.ejb.entities.Rol;
import org.utp.web.back.ejb.repositories.RolRepository;

import java.util.List;

@Stateless
public class RolEjbServiceImpl implements RolEjbService {

    @Inject
    private RolRepository repository;

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Rol> listado(List<Integer> estados) {
        return repository.findByEstadoIn(estados);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Rol encontrarId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Rol save(Integer id, Rol oDTO) {
        if ( id == null || id == 0){
            return repository.insertar(oDTO);
        } else {
            Rol oBD = repository.findById(id).orElse(null);
            if ( oBD != null ){
                oBD.setDescripcion(oDTO.getDescripcion());
                oBD.setEstado(oDTO.getEstado());
                return repository.actualizar(oBD);
            }
            return null;
        }
    }

    @Override
    public Integer estadoCero(Integer id) {
        Rol oBD = repository.findById(id).orElse(null);

        if ( oBD != null ) {
            //repository.deleteById(oBD.getId());
            oBD.setEstado(0);
            repository.actualizar(oBD);
            return 1;
        }
        return 0;
    }

}

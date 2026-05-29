package org.utp.web.back.ejb.services;

import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.inject.Inject;
import org.utp.web.back.ejb.entities.Cliente;
import org.utp.web.back.ejb.repositories.ClienteRepository;

import java.util.List;

@Stateless
public class ClienteEjbServiceImpl implements ClienteEjbService {

    @Inject
    private ClienteRepository repository;

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Cliente> listado(List<Integer> estados) {
        return repository.findByEstadoIn(estados);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Cliente encontrarId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Cliente save(Integer id, Cliente oDTO) {
        if ( id == null || id == 0){
            //oDTO.setClave( passwordEncoder.encode( oDTO.getClave() ) );
            //return mapper.toDTO(repository.save(mapper.toEntity(oDTO)));
            return null;
        } else {
            Cliente oBD = repository.findById(id).orElse(null);
            if ( oBD != null ){
                oBD.setNombres(oDTO.getNombres());
                oBD.setApellidos(oDTO.getApellidos());
                oBD.setEstado(oDTO.getEstado());
                return repository.actualizar(oBD);
            }
            return null;
        }
    }

    @Override
    public Integer estadoCero(Integer id) {
        Cliente oBD = repository.findById(id).orElse(null);

        if ( oBD != null ) {
            //repository.deleteById(oBD.getId());
            oBD.setEstado(0);
            repository.actualizar(oBD);
            return 1;
        }
        return 0;
    }

    @Override
    public Integer actualizarClave(Integer id, String newClave) {
        Cliente oBD = repository.findById(id).orElse(null);

        if ( oBD != null ) {
            oBD.setClave( newClave );
            repository.actualizar(oBD);
            return 1;
        }
        return 0;
    }

}

package org.utp.web.back.ejb.services;

import java.util.List;

import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import org.utp.web.back.ejb.entities.Marca;
import org.utp.web.back.ejb.repositories.MarcaRepository;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class MarcaEjbServiceImpl implements MarcaEjbService {

    @Inject
    private MarcaRepository repository;

    @Override
    public List<Marca> listarTodos() {
        return repository.findAll().toList();
    }

    @Override
    public Marca buscarMarca(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Marca> listado(List<Integer> estados) {
        return repository.findByEstadoIn(estados);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Marca encontrarId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Marca save(Integer id, Marca oDTO) {
        if ( id == null || id == 0){
            return repository.insertar(oDTO);
        } else {
            Marca oBD = repository.findById(id).orElse(null);
            if ( oBD != null ){
                oBD.setNombre(oDTO.getNombre());
                oBD.setEstado(oDTO.getEstado());
                return repository.actualizar(oBD);
            }
            return null;
        }
    }

    @Override
    public Integer estadoCero(Integer id) {
        Marca oBD = repository.findById(id).orElse(null);

        if ( oBD != null ) {
            //repository.deleteById(oBD.getId());
            oBD.setEstado(0);
            repository.actualizar(oBD);
            return 1;
        }
        return 0;
    }

}

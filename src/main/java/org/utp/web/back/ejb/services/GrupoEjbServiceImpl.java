package org.utp.web.back.ejb.services;

import java.util.List;

import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import org.utp.web.back.ejb.entities.Grupo;
import org.utp.web.back.ejb.repositories.GrupoRepository;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GrupoEjbServiceImpl implements GrupoEjbService {

    @Inject
    private GrupoRepository repository;

    @Override
    public List<Grupo> listarPorIdDepartamento(Integer idDep) {
        return repository.listarPorIdDepartamento(idDep);
    }

    @Override
    public Grupo buscarGrupo(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Grupo> listado(Integer codDepartamento, List<Integer> estados) {
        return repository.findByDepartamentoIdAndEstadoIn(codDepartamento, estados);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Grupo encontrarId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Grupo save(Integer id, Grupo oDTO) {
        if ( id == null || id == 0){
            return repository.insertar(oDTO);
        } else {
            Grupo oBD = repository.findById(id).orElse(null);
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
        Grupo oBD = repository.findById(id).orElse(null);

        if ( oBD != null ) {
            //repository.deleteById(oBD.getId());
            oBD.setEstado(0);
            repository.actualizar(oBD);
            return 1;
        }
        return 0;
    }

}
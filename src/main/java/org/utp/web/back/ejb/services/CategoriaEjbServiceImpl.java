package org.utp.web.back.ejb.services;

import java.util.List;

import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import org.utp.web.back.ejb.entities.Categoria;
import org.utp.web.back.ejb.repositories.CategoriaRepository;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class CategoriaEjbServiceImpl implements CategoriaEjbService {

    @Inject
    private CategoriaRepository repository;

    @Override
    public List<Categoria> listarPorIdGrupo(Integer idGrupo) {
        return repository.listarPorIdGrupo(idGrupo);
    }

    @Override
    public Categoria buscarCategoria(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Categoria> listado(Integer grupo, List<Integer> estados) {
        return repository.findByGrupoIdAndEstadoIn(grupo, estados);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Categoria encontrarId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Categoria save(Integer id, Categoria oDTO) {
        if ( id == null || id == 0){
            return repository.insertar(oDTO);
        } else {
            Categoria oBD = repository.findById(id).orElse(null);
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
        Categoria oBD = repository.findById(id).orElse(null);

        if ( oBD != null ) {
            //repository.deleteById(oBD.getId());
            oBD.setEstado(0);
            repository.actualizar(oBD);
            return 1;
        }
        return 0;
    }

}
package org.utp.web.back.ejb.services;

import java.util.List;

import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import org.utp.web.back.apirest.models.dto.CategoriaDTO;
import org.utp.web.back.apirest.models.mappers.CategoriaMapper;
import org.utp.web.back.ejb.entities.Categoria;
import org.utp.web.back.ejb.repositories.CategoriaRepository;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class CategoriaEjbServiceImpl implements CategoriaEjbService {

    @Inject
    private CategoriaRepository repository;

    @Inject
    private CategoriaMapper mapper;

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
    public List<CategoriaDTO> listarCategoriaPorGrupo(Integer grupo, List<Integer> estados) {
        return mapper.toDTOList( repository.findByGrupoIdAndEstadoIn(grupo, estados) );
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public CategoriaDTO encontrarId(Integer id) {
        return mapper.toDTO( repository.findById(id).orElse(null) );
    }

    @Override
    public CategoriaDTO save(Integer id, CategoriaDTO oDTO) {
        if ( id == null || id == 0){
            return mapper.toDTO( repository.insertar( mapper.toEntity( oDTO ) ) );
        } else {
            CategoriaDTO oBD = mapper.toDTO( repository.findById(id).orElse(null) );
            if ( oBD != null ){
                oBD.setNombre(oDTO.getNombre());
                oBD.setEstado(oDTO.getEstado());
                return mapper.toDTO( repository.actualizar( mapper.toEntity( oBD ) ) );
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

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<CategoriaDTO> listadoxGrupos(List<Integer> grupos, List<Integer> estados) {
        return mapper.toDTOList( repository.findByGrupoIdInAndEstadoIn(grupos, estados) );
    }

}
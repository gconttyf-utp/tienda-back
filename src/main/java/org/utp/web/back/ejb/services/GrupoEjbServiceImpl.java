package org.utp.web.back.ejb.services;

import java.util.List;

import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import org.utp.web.back.apirest.models.dto.GrupoDTO;
import org.utp.web.back.apirest.models.mappers.GrupoMapper;
import org.utp.web.back.ejb.entities.Grupo;
import org.utp.web.back.ejb.repositories.GrupoRepository;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GrupoEjbServiceImpl implements GrupoEjbService {

    @Inject
    private GrupoRepository repository;

    @Inject
    private GrupoMapper mapper;

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
    public List<GrupoDTO> listado(Integer codDepartamento, List<Integer> estados) {
        return mapper.toDTOList(repository.findByDepartamentoIdAndEstadoIn(codDepartamento, estados));
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public GrupoDTO encontrarId(Integer id) {
        return mapper.toDTO( repository.findById(id).orElse(null) );
    }

    @Override
    public GrupoDTO save(Integer id, GrupoDTO oDTO) {
        if ( id == null || id == 0){
            return mapper.toDTO( repository.insertar( mapper.toEntity( oDTO ) ) );
        } else {
            GrupoDTO oBD = mapper.toDTO( repository.findById(id).orElse(null) );
            if ( oBD != null ){
                oBD.setNombre(oDTO.getNombre());
                oBD.setEstado(oDTO.getEstado());
                oBD.setDepartamentoId( oDTO.getDepartamentoId() );
                return mapper.toDTO( repository.actualizar( mapper.toEntity( oBD ) ) );
            }
            return null;
        }
    }

    @Override
    public Integer estadoCero(Integer id) {
        Grupo oBD = repository.findById(id).orElse(null);

        if ( oBD != null ) {
            //repository.deleteById(oBD.getId());
            if ( oBD.getEstado() == 1 )
                oBD.setEstado(0);
            else
                oBD.setEstado(1);
            repository.actualizar(oBD);
            return 1;
        }
        return 0;
    }

}
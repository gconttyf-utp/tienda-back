package org.utp.web.back.apirest.services;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import org.utp.web.back.ejb.services.CategoriaEjbService;
import org.utp.web.back.apirest.models.dto.CategoriaDTO;
import org.utp.web.back.apirest.models.mappers.CategoriaMapper;

import java.util.List;

@RequestScoped
public class CategoriaServiceImpl implements CategoriaService {

    @Inject
    private CategoriaEjbService service;

    @Inject
    private CategoriaMapper mapper;

    @Override
    public List<CategoriaDTO> listarCategoriaPorGrupo(Integer grupoID, List<Integer> estados) {
        return mapper.toDTOList( service.listado(grupoID, estados) );
    }
}

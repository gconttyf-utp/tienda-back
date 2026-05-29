package org.utp.web.back.apirest.services;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import org.utp.web.back.ejb.services.GrupoEjbService;
import org.utp.web.back.apirest.models.dto.GrupoDTO;
import org.utp.web.back.apirest.models.mappers.GrupoMapper;

import java.util.List;

@RequestScoped
public class GrupoServiceImpl implements  GrupoService {

    @Inject
    private GrupoEjbService service;

    @Inject
    private GrupoMapper mapper;

    @Override
    public List<GrupoDTO> listarGrupos(Integer depaID, List<Integer> estados) {
        return mapper.toDTOList(service.listado(depaID, estados));
    }
}

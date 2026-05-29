package org.utp.web.back.apirest.services;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import org.utp.web.back.ejb.services.MarcaEjbService;
import org.utp.web.back.apirest.models.dto.MarcaDTO;
import org.utp.web.back.apirest.models.mappers.MarcaMapper;

import java.util.List;

@RequestScoped
public class MarcaServiceImpl implements MarcaService {

    @Inject
    private MarcaEjbService service;

    @Inject
    private MarcaMapper mapper;

    @Override
    public List<MarcaDTO> listarMarca(List<Integer> estados) {
        return mapper.toDTOList( service.listado(estados) );
    }
}

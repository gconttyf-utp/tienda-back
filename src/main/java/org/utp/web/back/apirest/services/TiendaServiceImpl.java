package org.utp.web.back.apirest.services;

import java.util.List;

import org.utp.web.back.ejb.services.TiendaEjbService;
import org.utp.web.back.apirest.models.dto.TiendaDTO;
import org.utp.web.back.apirest.models.mappers.TiendaMapper;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class TiendaServiceImpl implements TiendaService {

    @Inject
    private TiendaEjbService service;

    @Inject
    private TiendaMapper mapper;

    @Override
    public List<TiendaDTO> listarTiendas(List<Integer> estados) {
        return mapper.toDTOList( service.listado(estados) );
    }

    @Override
    public List<TiendaDTO> listarTiendasUbigeo(String codUbigeo, List<Integer> estados) {
        return mapper.toDTOList( service.listadoUbigeo(codUbigeo, estados) );
    }

}

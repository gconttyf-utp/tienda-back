package org.utp.web.back.apirest.services;

import java.util.List;

import org.utp.web.back.ejb.services.RolEjbService;
import org.utp.web.back.apirest.models.dto.RolDTO;
import org.utp.web.back.apirest.models.mappers.RolMapper;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class RolServiceImpl implements RolService {

    @Inject
    private RolEjbService service;

    @Inject
    private RolMapper mapper;

    @Override
    public List<RolDTO> listarRoles(List<Integer> estados) {
        return mapper.toDTOList(service.listado(estados));
    }



}
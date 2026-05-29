package org.utp.web.back.apirest.services;

import java.util.List;

import org.utp.web.back.ejb.services.UsuarioEjbService;
import org.utp.web.back.apirest.models.dto.UsuarioDTO;
import org.utp.web.back.apirest.models.mappers.UsuarioMapper;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class UsuarioServiceImpl implements UsuarioService {

    @Inject
    private UsuarioEjbService service;

    @Inject
    private UsuarioMapper mapper;

    @Override
    public List<UsuarioDTO> listarUsuarios(List<Integer> estados) {
        return mapper.toDTOList(service.listado(estados));
    }

    @Override
    public UsuarioDTO encUsuario(Integer id) {
        return mapper.toDTO(service.encontrarId(id));
    }


}

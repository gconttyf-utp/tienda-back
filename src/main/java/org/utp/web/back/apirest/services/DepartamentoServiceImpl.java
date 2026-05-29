package org.utp.web.back.apirest.services;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import org.utp.web.back.ejb.services.DepartamentoEjbService;
import org.utp.web.back.apirest.models.dto.DepartamentoDTO;
import org.utp.web.back.apirest.models.mappers.DepartamentoMapper;

import java.util.List;

@RequestScoped
public class DepartamentoServiceImpl implements  DepartamentoService {

    @Inject
    private DepartamentoEjbService departamentoService;

    @Inject
    private DepartamentoMapper departamentoMapper;

    @Override
    public List<DepartamentoDTO> listarDepartamentos(List<Integer> estados) {
        //List<DepartamentoDTO> depList = departamentoService.listarTodos().stream().map( depa -> departamentoMapper.toDTO(depa)).toList();
        //return depList;        
        return departamentoMapper.toDTOList(departamentoService.listarDepartamentos(estados));
    }

    @Override
    public DepartamentoDTO encDepartamento(Integer id) {
        return null;
    }
}

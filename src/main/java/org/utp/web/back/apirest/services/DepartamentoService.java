package org.utp.web.back.apirest.services;

import org.utp.web.back.apirest.models.dto.DepartamentoDTO;

import java.util.List;

public interface DepartamentoService {

    List<DepartamentoDTO> listarDepartamentos(List<Integer> estados);

    DepartamentoDTO encDepartamento(Integer id);
}

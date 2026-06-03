package org.utp.web.back.ejb.services;

import java.util.List;

import jakarta.ejb.Local;
import org.utp.web.back.apirest.models.dto.DepartamentoDTO;
import org.utp.web.back.ejb.entities.Departamento;

@Local
public interface DepartamentoEjbService {

    List<Departamento> listarTodos();

    Departamento buscarDepartamento(Integer id);

    List<DepartamentoDTO> listarDepartamentos(List<Integer> estados);

    DepartamentoDTO encontrarDepartamento(Integer id);

    DepartamentoDTO salvarDepartamento(Integer id, DepartamentoDTO departamento);

    Integer eliminarDepartamento(Integer id);
}

package org.utp.web.back.ejb.services;

import java.util.List;

import jakarta.ejb.Local;
import org.utp.web.back.ejb.entities.Departamento;

@Local
public interface DepartamentoEjbService {

    List<Departamento> listarTodos();

    Departamento buscarDepartamento(Integer id);

    List<Departamento> listarDepartamentos(List<Integer> estados);

    Departamento encontrarDepartamento(Integer id);

    Departamento salvarDepartamento(Integer id, Departamento departamento);

    Integer eliminarDepartamento(Integer id);
}

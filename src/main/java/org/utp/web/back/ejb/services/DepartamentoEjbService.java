package org.utp.web.back.ejb.services;

import java.util.List;

import org.utp.web.back.ejb.entities.Departamento;

import jakarta.ejb.Remote;

@Remote
public interface DepartamentoEjbService {

    List<Departamento> listarTodos();

    Departamento buscarDepartamento(Integer id);

    List<Departamento> listarDepartamentos(List<Integer> estados);

    Departamento encontrarDepartamento(Integer id);

    Departamento salvarDepartamento(Integer id, Departamento departamento);

    Integer eliminarDepartamento(Integer id);
}

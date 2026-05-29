package org.utp.web.back.ejb.services;

import java.util.List;

import jakarta.ejb.Local;
import org.utp.web.back.ejb.entities.Grupo;

@Local
public interface GrupoEjbService {

    List<Grupo> listarPorIdDepartamento(Integer idDep);

    Grupo buscarGrupo(Integer id);

    List<Grupo> listado(Integer codDepartamento, List<Integer> estados);

    Grupo encontrarId(Integer id);

    Grupo save(Integer id, Grupo oDTO);

    Integer estadoCero(Integer id);
}

package org.utp.web.back.ejb.services;

import java.util.List;

import jakarta.ejb.Local;
import org.utp.web.back.apirest.models.dto.GrupoDTO;
import org.utp.web.back.ejb.entities.Grupo;

@Local
public interface GrupoEjbService {

    List<Grupo> listarPorIdDepartamento(Integer idDep);

    Grupo buscarGrupo(Integer id);

    List<GrupoDTO> listado(Integer codDepartamento, List<Integer> estados);

    GrupoDTO encontrarId(Integer id);

    GrupoDTO save(Integer id, GrupoDTO oDTO);

    Integer estadoCero(Integer id);
}

package org.utp.web.back.ejb.services;

import java.util.List;

import jakarta.ejb.Local;
import org.utp.web.back.ejb.entities.Categoria;

@Local
public interface CategoriaEjbService {

    List<Categoria> listarPorIdGrupo(Integer idGrupo);

    Categoria buscarCategoria(Integer id);

    List<Categoria> listado(Integer grupo, List<Integer> estados);

    Categoria encontrarId(Integer id);

    Categoria save(Integer id, Categoria oDTO);

    Integer estadoCero(Integer id);

}

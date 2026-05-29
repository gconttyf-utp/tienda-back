package org.utp.web.back.ejb.services;

import java.util.List;

import org.utp.web.back.ejb.entities.Categoria;

import jakarta.ejb.Remote;

@Remote
public interface CategoriaEjbService {

    List<Categoria> listarPorIdGrupo(Integer idGrupo);

    Categoria buscarCategoria(Integer id);

    List<Categoria> listado(Integer grupo, List<Integer> estados);

    Categoria encontrarId(Integer id);

    Categoria save(Integer id, Categoria oDTO);

    Integer estadoCero(Integer id);

}

package org.utp.web.back.ejb.services;

import java.util.List;

import jakarta.ejb.Local;
import org.utp.web.back.apirest.models.dto.CategoriaDTO;
import org.utp.web.back.ejb.entities.Categoria;

@Local
public interface CategoriaEjbService {

    List<Categoria> listarPorIdGrupo(Integer idGrupo);

    Categoria buscarCategoria(Integer id);

    List<CategoriaDTO> listarCategoriaPorGrupo(Integer grupo, List<Integer> estados);

    CategoriaDTO encontrarId(Integer id);

    CategoriaDTO save(Integer id, CategoriaDTO oDTO);

    Integer estadoCero(Integer id);

    List<CategoriaDTO> listadoxGrupos(List<Integer> grupos, List<Integer> estados);

}

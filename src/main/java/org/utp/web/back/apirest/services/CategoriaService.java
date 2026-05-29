package org.utp.web.back.apirest.services;

import org.utp.web.back.apirest.models.dto.CategoriaDTO;

import java.util.List;

public interface CategoriaService {

    List<CategoriaDTO> listarCategoriaPorGrupo(Integer grupoID, List<Integer> estados);
}

package org.utp.web.back.apirest.services;

import org.utp.web.back.apirest.models.dto.GrupoDTO;

import java.util.List;

public interface GrupoService {

    List<GrupoDTO> listarGrupos(Integer depaID, List<Integer> estados);
}

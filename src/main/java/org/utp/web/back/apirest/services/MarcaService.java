package org.utp.web.back.apirest.services;

import org.utp.web.back.apirest.models.dto.MarcaDTO;

import java.util.List;

public interface MarcaService {

    List<MarcaDTO> listarMarca(List<Integer> estados);
}

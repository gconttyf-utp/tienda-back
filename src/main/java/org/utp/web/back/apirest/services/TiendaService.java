package org.utp.web.back.apirest.services;

import java.util.List;

import org.utp.web.back.apirest.models.dto.TiendaDTO;

public interface TiendaService {

    List<TiendaDTO> listarTiendas(List<Integer> estados);

    List<TiendaDTO> listarTiendasUbigeo(String codUbigeo, List<Integer> estados);

}

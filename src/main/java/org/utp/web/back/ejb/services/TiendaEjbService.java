package org.utp.web.back.ejb.services;

import jakarta.ejb.Local;
import org.utp.web.back.apirest.models.dto.TiendaDTO;
import org.utp.web.back.ejb.entities.Tienda;

import java.util.List;

@Local
public interface TiendaEjbService {

    List<TiendaDTO> listado(List<Integer> estados);

    List<TiendaDTO> listadoUbigeo(String ubigeo, List<Integer> estados);

    Tienda encontrarId(Integer id);

    Tienda save(Integer id, Tienda oDTO);

    Integer estadoCero(Integer id);

}

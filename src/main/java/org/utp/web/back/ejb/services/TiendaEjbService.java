package org.utp.web.back.ejb.services;

import jakarta.ejb.Remote;
import org.utp.web.back.ejb.entities.Tienda;

import java.util.List;

@Remote
public interface TiendaEjbService {

    List<Tienda> listado(List<Integer> estados);

    List<Tienda> listadoUbigeo(String ubigeo, List<Integer> estados);

    Tienda encontrarId(Integer id);

    Tienda save(Integer id, Tienda oDTO);

    Integer estadoCero(Integer id);

}

package org.utp.web.back.ejb.services;

import jakarta.ejb.Local;
import org.utp.web.back.ejb.entities.Rol;

import java.util.List;

@Local
public interface RolEjbService {

    List<Rol> listado(List<Integer> estados);

    Rol encontrarId(Integer id);

    Rol save(Integer id, Rol oDTO);

    Integer estadoCero(Integer id);
}

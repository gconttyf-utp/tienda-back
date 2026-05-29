package org.utp.web.back.ejb.services;

import jakarta.ejb.Remote;
import org.utp.web.back.ejb.entities.Rol;

import java.util.List;

@Remote
public interface RolEjbService {

    List<Rol> listado(List<Integer> estados);

    Rol encontrarId(Integer id);

    Rol save(Integer id, Rol oDTO);

    Integer estadoCero(Integer id);
}

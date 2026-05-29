package org.utp.web.back.ejb.services;

import jakarta.ejb.Local;
import org.utp.web.back.apirest.models.dto.RolDTO;
import org.utp.web.back.ejb.entities.Rol;

import java.util.List;

@Local
public interface RolEjbService {

    List<RolDTO> listado(List<Integer> estados);

    Rol encontrarId(Integer id);

    Rol save(Integer id, Rol oDTO);

    Integer estadoCero(Integer id);
}

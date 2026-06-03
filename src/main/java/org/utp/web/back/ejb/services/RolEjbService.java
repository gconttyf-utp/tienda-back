package org.utp.web.back.ejb.services;

import jakarta.ejb.Local;
import org.utp.web.back.apirest.models.dto.RolDTO;
import org.utp.web.back.ejb.entities.Rol;

import java.util.List;

@Local
public interface RolEjbService {

    List<RolDTO> listado(List<Integer> estados);

    RolDTO encontrarId(Integer id);

    RolDTO save(Integer id, RolDTO oDTO);

    Integer estadoCero(Integer id);
}

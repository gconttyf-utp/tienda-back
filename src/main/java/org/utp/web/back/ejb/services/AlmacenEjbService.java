package org.utp.web.back.ejb.services;

import jakarta.ejb.Local;
import org.utp.web.back.apirest.models.dto.AlmacenDTO;

import java.util.List;

@Local
public interface AlmacenEjbService {

    List<AlmacenDTO> listado(Integer tienda);

    AlmacenDTO encontrarId(Integer id);

    AlmacenDTO save(Integer id, AlmacenDTO oDTO);

}

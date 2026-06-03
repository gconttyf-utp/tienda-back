package org.utp.web.back.ejb.services;

import jakarta.ejb.Local;
import org.utp.web.back.apirest.models.dto.ClienteDTO;

import java.util.List;

@Local
public interface ClienteEjbService {

    List<ClienteDTO> listado(List<Integer> estados);

    ClienteDTO encontrarId(Integer id);

    ClienteDTO save(Integer id, ClienteDTO oDTO);

    Integer estadoCero(Integer id);

    Integer actualizarClave(Integer id, String newClave);

}

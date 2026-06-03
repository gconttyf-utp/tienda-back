package org.utp.web.back.ejb.services;

import jakarta.ejb.Local;
import org.utp.web.back.apirest.models.dto.UsuarioDTO;
import org.utp.web.back.ejb.entities.Usuario;

import java.util.List;

@Local
public interface UsuarioEjbService {

    List<UsuarioDTO> listado(List<Integer> estados);

    UsuarioDTO encontrarId(Integer id);

    UsuarioDTO save(Integer id, UsuarioDTO oDTO);

    Integer estadoCero(Integer id);

    Integer actualizarClave(Integer id, String newClave);

}

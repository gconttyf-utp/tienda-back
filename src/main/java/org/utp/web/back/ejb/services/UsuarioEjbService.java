package org.utp.web.back.ejb.services;

import jakarta.ejb.Remote;
import org.utp.web.back.ejb.entities.Usuario;

import java.util.List;

@Remote
public interface UsuarioEjbService {

    List<Usuario> listado(List<Integer> estados);

    Usuario encontrarId(Integer id);

    Usuario save(Integer id, Usuario oDTO);

    Integer estadoCero(Integer id);

    Integer actualizarClave(Integer id, String newClave);

}

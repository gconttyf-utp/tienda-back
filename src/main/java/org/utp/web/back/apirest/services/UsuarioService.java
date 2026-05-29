package org.utp.web.back.apirest.services;

import java.util.List;

import org.utp.web.back.apirest.models.dto.UsuarioDTO;

public interface UsuarioService {

    List<UsuarioDTO> listarUsuarios(List<Integer> estados);

    UsuarioDTO encUsuario(Integer id);

}

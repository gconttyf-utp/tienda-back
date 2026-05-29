package org.utp.web.back.apirest.services;

import java.util.List;

import org.utp.web.back.apirest.models.dto.RolDTO;

public interface RolService {

    List<RolDTO> listarRoles(List<Integer> estados);

}

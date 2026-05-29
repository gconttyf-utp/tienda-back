package org.utp.web.back.apirest.services;

import org.utp.web.back.apirest.models.dto.ClienteDTO;
import org.utp.web.back.apirest.models.dto.LoginDTO;
import org.utp.web.back.apirest.models.dto.LoginJWT;

public interface LoginService {

    LoginJWT loginClienteJWT(LoginDTO loginDTO);

    ClienteDTO registrarCliente(ClienteDTO clienteDTO);

    LoginJWT loginUsuarioJWT(LoginDTO loginDTO);

}

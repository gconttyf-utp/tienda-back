package org.utp.web.back.ejb.services;

import org.utp.web.back.ejb.entities.Cliente;

import jakarta.ejb.Remote;
import org.utp.web.back.ejb.entities.Usuario;

@Remote
public interface AutorizacionService {

    Cliente login(String correo, Integer estado);

    Cliente registrar(Cliente cliente);

    Usuario loginUsuario(String usuario, Integer estado);

}

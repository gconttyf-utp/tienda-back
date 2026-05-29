package org.utp.web.back.ejb.services;

import jakarta.ejb.Local;
import org.utp.web.back.ejb.entities.Cliente;
import org.utp.web.back.ejb.entities.Usuario;

@Local
public interface AutorizacionService {

    Cliente login(String correo, Integer estado);

    Cliente registrar(Cliente cliente);

    Usuario loginUsuario(String usuario, Integer estado);

}

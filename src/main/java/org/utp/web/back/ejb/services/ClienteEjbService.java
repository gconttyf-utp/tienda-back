package org.utp.web.back.ejb.services;

import jakarta.ejb.Local;
import org.utp.web.back.ejb.entities.Cliente;

import java.util.List;

@Local
public interface ClienteEjbService {

    List<Cliente> listado(List<Integer> estados);

    Cliente encontrarId(Integer id);

    Cliente save(Integer id, Cliente oDTO);

    Integer estadoCero(Integer id);

    Integer actualizarClave(Integer id, String newClave);

}

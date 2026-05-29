package org.utp.web.back.ejb.services;

import java.util.List;

import org.utp.web.back.ejb.entities.Marca;

import jakarta.ejb.Remote;

@Remote
public interface MarcaEjbService {

    List<Marca> listarTodos();

    Marca buscarMarca(Integer id);

    List<Marca> listado(List<Integer> estados);

    Marca encontrarId(Integer id);

    Marca save(Integer id, Marca oDTO);

    Integer estadoCero(Integer id);

}

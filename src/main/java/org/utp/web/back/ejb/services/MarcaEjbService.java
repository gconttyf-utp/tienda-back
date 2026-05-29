package org.utp.web.back.ejb.services;

import java.util.List;

import jakarta.ejb.Local;
import org.utp.web.back.apirest.models.dto.MarcaDTO;
import org.utp.web.back.ejb.entities.Marca;

@Local
public interface MarcaEjbService {

    List<Marca> listarTodos();

    Marca buscarMarca(Integer id);

    List<MarcaDTO> listado(List<Integer> estados);

    Marca encontrarId(Integer id);

    Marca save(Integer id, Marca oDTO);

    Integer estadoCero(Integer id);

}

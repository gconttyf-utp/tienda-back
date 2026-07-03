package org.utp.web.back.ejb.services;

import jakarta.ejb.Local;
import org.utp.web.back.apirest.models.dto.ClienteDTO;
import org.utp.web.back.apirest.models.dto.ReclamoDTO;
import org.utp.web.back.ejb.entities.enums.EstadoReclamo;

import java.util.List;

@Local
public interface ReclamoEjbService {

    ReclamoDTO save (Integer id, ReclamoDTO oDTO);

    ReclamoDTO encontrarID(Integer id);

    List<ReclamoDTO> listarTodos();

    List<ReclamoDTO> listarPorCliente(Integer clienteId);

    List<ReclamoDTO> listarPorEstado(EstadoReclamo estado);

    List<ClienteDTO> listarReclamosPorClientesPendientes();

}

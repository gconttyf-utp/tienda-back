package org.utp.web.back.ejb.services;

import jakarta.ejb.Local;
import org.utp.web.back.apirest.models.dto.PedidoDTO;
import org.utp.web.back.ejb.entities.enums.EstadoPedido;

import java.util.List;

@Local
public interface PedidoEjbService {

    PedidoDTO nuevo(PedidoDTO oDTO);

    PedidoDTO actualizarPago(Integer id, Integer pago);

    PedidoDTO actualizarDespacho(Integer id);

    PedidoDTO actualizarRecojo(Integer id);

    List<PedidoDTO> listarTodos();

    PedidoDTO encontrarID(Integer id);

    List<PedidoDTO> listarPorCliente(Integer clienteId);

    List<PedidoDTO> listarPorTienda(Integer tiendaId);

    List<PedidoDTO> listarPorEstado(EstadoPedido estado);

    List<PedidoDTO> listarPendientePago();

    List<PedidoDTO> listarTodosConDetalle();

    List<PedidoDTO> listarPorClienteAndEstado(Integer clienteId, EstadoPedido estado);

}

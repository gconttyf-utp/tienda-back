package org.utp.web.back.ejb.repositories;

import jakarta.data.repository.*;
import org.utp.web.back.ejb.entities.Pedido;

import java.util.List;

@Repository
public interface PedidoRepository {

    @Insert
    Pedido insertar(Pedido pedido);

    @Update
    Pedido actualizar(Pedido pedido);

    /**
     * Lista todos los pedidos.
     */
    @Query("SELECT p FROM Pedido p")
    List<Pedido> findAll();

    /**
     * Lista los pedidos por el ID del Cliente.
     */
    @Query("SELECT p FROM Pedido p WHERE p.cliente.id = :clienteId")
    List<Pedido> findByClienteId(@Param("clienteId") Integer clienteId);

    /**
     * Lista los pedidos por el ID de la Tienda.
     */
    @Query("SELECT p FROM Pedido p WHERE p.tienda.id = :tiendaId")
    List<Pedido> findByTiendaId(@Param("tiendaId") Integer tiendaId);

    /**
     * Lista los pedidos por un estado específico.
     */
    @Query("SELECT p FROM Pedido p WHERE p.estado = :estado")
    List<Pedido> findByEstado(@Param("estado") String estado);

    /**
     * Lista los pedidos que tienen el estado 'PENDIENTE_PAGO'.
     */
    @Query("SELECT p FROM Pedido p WHERE p.estado = 'PENDIENTE_PAGO'")
    List<Pedido> findPendientesDePago();

    /**
     * Lista todos los pedidos, incluyendo sus detalles (PedidoDetalle) en una sola consulta.
     * Se usa JOIN FETCH para cargar la colección de detalles de forma eficiente.
     */
    @Query("SELECT DISTINCT p FROM Pedido p LEFT JOIN FETCH p.pedidosDetalle")
    List<Pedido> findAllWithDetalles();
}

package org.utp.web.back.ejb.repositories;

import jakarta.data.repository.*;
import org.utp.web.back.ejb.entities.Pedido;
import org.utp.web.back.ejb.entities.enums.EstadoPedido;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Integer> {

    @Insert
    Pedido insertar(Pedido pedido);

    @Update
    Pedido actualizar(Pedido pedido);

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
    List<Pedido> findByEstado(@Param("estado") EstadoPedido estado);

    /**
     * Lista los pedidos que tienen el estado 'PENDIENTE_PAGO'.
     */
    @Query("SELECT p FROM Pedido p WHERE p.estado = org.utp.web.back.ejb.entities.enums.EstadoPedido.PENDIENTE_PAGO")
    List<Pedido> findPendientesDePago();

    /**
     * Lista todos los pedidos, incluyendo sus detalles (PedidoDetalle) en una sola consulta.
     * Se usa JOIN FETCH para cargar la colección de detalles de forma eficiente.
     */
    @Query("SELECT DISTINCT p FROM Pedido p " +
           "LEFT JOIN FETCH p.detalles " +
           "LEFT JOIN FETCH p.cliente " +
           "LEFT JOIN FETCH p.tienda")
    List<Pedido> findAllWithDetalles();

    @Query("SELECT p FROM Pedido p WHERE p.cliente.id = :clienteId AND p.estado = :estado")
    List<Pedido> findByClienteAndEstado(@Param("clienteId") Integer clienteId, @Param("estado") EstadoPedido estado);

    /**
     * Actualiza el estado y la fecha de pago de un pedido usando JPQL nativo de Jakarta Data.
     * * @param pedidoId El ID del pedido a actualizar.
     * @param nuevoEstado El nuevo estado (usamos el Enum en lugar de String por seguridad).
     * @return int con la cantidad de registros modificados (opcional, puedes usar void).
     */
    @Query("UPDATE Pedido p SET p.estado = :nuevoEstado, p.fechaPago = :fechaPago WHERE p.id = :pedidoId")
    int confirmarPago(@Param("pedidoId") Integer pedidoId, @Param("nuevoEstado") EstadoPedido nuevoEstado, @Param("fechaPago") LocalDateTime fechaPago);

    @Query("UPDATE Pedido p SET p.estado = :nuevoEstado, p.fechaDespacho = :fechaDespacho WHERE p.id = :pedidoId")
    int confirmarDespacho(@Param("pedidoId") Integer pedidoId, @Param("nuevoEstado") EstadoPedido nuevoEstado, @Param("fechaDespacho") LocalDateTime fechaDespacho);

    @Query("UPDATE Pedido p SET p.estado = :nuevoEstado, p.fechaRecojo = :fechaRecojo WHERE p.id = :pedidoId")
    int confirmarRecojo(@Param("pedidoId") Integer pedidoId, @Param("nuevoEstado") EstadoPedido nuevoEstado, @Param("fechaRecojo") LocalDateTime fechaRecojo);

    @Query("SELECT p FROM Pedido p " +
            "LEFT JOIN FETCH p.detalles " +
            "LEFT JOIN FETCH p.cliente " +
            "LEFT JOIN FETCH p.tienda " +
            "WHERE p.id = :pedidoId")
    Pedido encontrarID( @Param("pedidoId") Integer pedidoId );
}

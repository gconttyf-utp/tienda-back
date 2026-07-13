package org.utp.web.back.ejb.repositories;

import jakarta.data.repository.*;
import org.utp.web.back.ejb.entities.Pedido;
import org.utp.web.back.ejb.entities.enums.EstadoPedido;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Integer> {

    @Insert
    Pedido insertar(Pedido pedido);

    @Update
    Pedido actualizar(Pedido pedido);

    /**
     * Lista los pedidos por el ID del Cliente.
     */
    @Query("SELECT p FROM Pedido p " +
            "LEFT JOIN FETCH p.cliente " +
            "LEFT JOIN FETCH p.tienda " +
            "LEFT JOIN FETCH p.tipoPago " +
            "LEFT JOIN FETCH p.detalles " +
            "WHERE p.cliente.id = :clienteId")
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

    @Query("SELECT p FROM Pedido p " +
            "LEFT JOIN FETCH p.cliente " +
            "LEFT JOIN FETCH p.tienda " +
            "LEFT JOIN FETCH p.tipoPago " +
            "LEFT JOIN FETCH p.detalles " +
            "WHERE p.cliente.id = :clienteId AND p.estado = :estado")
    List<Pedido> findByClienteAndEstado(@Param("clienteId") Integer clienteId, @Param("estado") EstadoPedido estado);
    
    @Query("UPDATE Pedido p SET p.estado = :nuevoEstado, p.fechaDespacho = :fechaDespacho WHERE p.id = :pedidoId")
    int confirmarDespacho(@Param("pedidoId") Integer pedidoId,
                          @Param("nuevoEstado") EstadoPedido nuevoEstado,
                          @Param("fechaDespacho") LocalDateTime fechaDespacho);
    
    @Query("UPDATE Pedido p SET p.estado = :nuevoEstado, p.fechaRecojo = :fechaRecojo WHERE p.id = :pedidoId")
    int confirmarRecojo(@Param("pedidoId") Integer pedidoId, @Param("nuevoEstado") EstadoPedido nuevoEstado, @Param("fechaRecojo") LocalDateTime fechaRecojo);

    /**
     * Encuentra un Pedido por su ID y carga todas sus relaciones (simples y colecciones)
     * para evitar LazyInitializationException en el mapeo a DTO.
     */
    @Query("SELECT p FROM Pedido p " +
            "LEFT JOIN FETCH p.cliente " +
            "LEFT JOIN FETCH p.tienda " +
            "LEFT JOIN FETCH p.tipoPago " +
            "LEFT JOIN FETCH p.detalles " +
            "WHERE p.id = :pedidoId")
    Optional<Pedido> findByIdWithRelations(@Param("pedidoId") Integer pedidoId);

}

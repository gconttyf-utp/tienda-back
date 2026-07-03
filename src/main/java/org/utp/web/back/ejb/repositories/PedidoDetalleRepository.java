package org.utp.web.back.ejb.repositories;

import jakarta.data.repository.*;
import org.utp.web.back.ejb.entities.PedidoDetalle;

import java.util.List;

@Repository
public interface PedidoDetalleRepository extends CrudRepository<PedidoDetalle, Integer> {

    @Insert
    PedidoDetalle insertar(PedidoDetalle detalle);

    @Update
    PedidoDetalle actualizar(PedidoDetalle detalle);

    /**
     * Lista los detalles de un pedido específico por el ID del Pedido.
     */
    @Query("SELECT pd FROM PedidoDetalle pd WHERE pd.pedido.id = :pedidoId")
    List<PedidoDetalle> findByPedidoId(@Param("pedidoId") Integer pedidoId);
}

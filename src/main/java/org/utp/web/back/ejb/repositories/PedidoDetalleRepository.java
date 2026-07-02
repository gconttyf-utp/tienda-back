package org.utp.web.back.ejb.repositories;

import jakarta.data.repository.Insert;
import jakarta.data.repository.Repository;
import jakarta.data.repository.Update;
import org.utp.web.back.ejb.entities.PedidoDetalle;

@Repository
public interface PedidoDetalleRepository {

    @Insert
    PedidoDetalle insertar(PedidoDetalle detalle);

    @Update
    PedidoDetalle actualizar(PedidoDetalle detalle);

}

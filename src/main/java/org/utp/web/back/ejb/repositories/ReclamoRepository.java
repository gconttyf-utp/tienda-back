package org.utp.web.back.ejb.repositories;

import jakarta.data.repository.*;
import org.utp.web.back.ejb.entities.Cliente;
import org.utp.web.back.ejb.entities.Reclamo;
import org.utp.web.back.ejb.entities.enums.EstadoReclamo;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReclamoRepository extends CrudRepository<Reclamo, Integer> {

    @Insert
    Reclamo insertar(Reclamo reclamo);

    @Update
    Reclamo actualizar(Reclamo reclamo);

    @Query("SELECT r FROM Reclamo r " +
            "LEFT JOIN FETCH r.cliente " +
            "LEFT JOIN FETCH r.pedido " +
            "WHERE r.cliente.id = :clienteId")
    List<Reclamo> findByClienteId(@Param("clienteId") Integer clienteId);

    @Query("SELECT r FROM Reclamo r " +
            "LEFT JOIN FETCH r.cliente " +
            "LEFT JOIN FETCH r.pedido " +
            "WHERE r.estado = :estado")
    List<Reclamo> findByEstado(@Param("estado") EstadoReclamo estado);

    @Query("SELECT DISTINCT r.cliente FROM Reclamo r WHERE r.estado = 'PENDIENTE'")
    List<Cliente> findClientesConReclamosPendientes();

    @Query("SELECT r FROM Reclamo r LEFT JOIN FETCH r.cliente LEFT JOIN FETCH r.pedido")
    List<Reclamo> findTodosWithRelations();

    @Query("SELECT r FROM Reclamo r " +
            "LEFT JOIN FETCH r.cliente " +
            "LEFT JOIN FETCH r.pedido " +
            "WHERE r.id = :reclamoId")
    Optional<Reclamo> findByIdWithRelations(@Param("reclamoId") Integer reclamoId);

}

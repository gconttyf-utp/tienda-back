package org.utp.web.back.ejb.repositories;

import jakarta.data.repository.*;
import org.utp.web.back.ejb.entities.Cliente;
import org.utp.web.back.ejb.entities.Reclamo;

import java.util.List;

@Repository
public interface ReclamoRepository {

    @Insert
    Reclamo insertar(Reclamo reclamo);

    @Update
    Reclamo actualizar(Reclamo reclamo);

    List<Reclamo> findAll();

    @Query("SELECT r FROM Reclamo r WHERE r.cliente.id = :clienteId")
    List<Reclamo> findByClienteId(@Param("clienteId") Integer clienteId);

    @Query("SELECT r FROM Reclamo r WHERE r.estado = :estado")
    List<Reclamo> findByEstado(@Param("estado") String estado);

    @Query("SELECT DISTINCT r.cliente FROM Reclamo r WHERE r.estado = 'PENDIENTE'")
    List<Cliente> findClientesConReclamosPendientes();

}

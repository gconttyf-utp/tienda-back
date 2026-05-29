package org.utp.web.back.ejb.repositories;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import jakarta.data.repository.*;
import org.utp.web.back.ejb.entities.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

    @Find
    Optional<Cliente> findByCorreoAndEstado(String correo, Integer estado);

    @Find
    Optional<Cliente> findByCorreoAndClaveAndEstado(String correo, String clave, Integer estado);

    @Query("SELECT o FROM Cliente o WHERE o.estado in (:estados)")
    List<Cliente> findByEstadoIn(Collection<Integer> estados);

    @Insert
    Cliente insertar(Cliente entidad);

    @Update
    Cliente actualizar(Cliente entidad);

}

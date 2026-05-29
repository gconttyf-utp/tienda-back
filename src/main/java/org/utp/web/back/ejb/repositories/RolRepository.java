package org.utp.web.back.ejb.repositories;

import jakarta.data.repository.*;
import org.utp.web.back.ejb.entities.Rol;

import java.util.Collection;
import java.util.List;

@Repository
public interface RolRepository extends CrudRepository<Rol, Integer> {

    @Query("SELECT o FROM Rol o WHERE o.estado in (:estados)")
    List<Rol> findByEstadoIn(Collection<Integer> estados);

    @Insert
    Rol insertar(Rol entidad);

    @Update
    Rol actualizar(Rol entidad);
}

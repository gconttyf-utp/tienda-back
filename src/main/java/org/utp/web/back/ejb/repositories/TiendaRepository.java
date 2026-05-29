package org.utp.web.back.ejb.repositories;

import jakarta.data.repository.*;
import org.utp.web.back.ejb.entities.Tienda;

import java.util.Collection;
import java.util.List;

@Repository
public interface TiendaRepository extends CrudRepository<Tienda, Integer> {

    @Query("SELECT o FROM Tienda o WHERE o.estado in (:estados)")
    List<Tienda> findByEstadoIn(Collection<Integer> estados);

    @Query("SELECT o FROM Tienda o WHERE o.ubigeo.codUbigeo = :ubigeo AND o.estado in (:estados)")
    List<Tienda> findByUbigeoCodUbigeoAndEstadoIn(String ubigeo, Collection<Integer> estados);

    @Insert
    Tienda insertar(Tienda entidad);

    @Update
    Tienda actualizar(Tienda entidad);

}

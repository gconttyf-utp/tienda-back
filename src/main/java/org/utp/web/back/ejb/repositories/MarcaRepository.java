package org.utp.web.back.ejb.repositories;

import jakarta.data.repository.*;
import org.utp.web.back.ejb.entities.Marca;
import org.utp.web.back.ejb.entities.Producto;

import java.util.Collection;
import java.util.List;

@Repository
public interface MarcaRepository extends CrudRepository<Marca, Integer> {

    @Query("SELECT o FROM Marca o WHERE o.estado in (:estados)")
    List<Marca> findByEstadoIn(Collection<Integer> estados);

    @Insert
    Marca insertar(Marca entidad);

    @Update
    Marca actualizar(Marca entidad);

}

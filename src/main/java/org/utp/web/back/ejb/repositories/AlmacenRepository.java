package org.utp.web.back.ejb.repositories;

import jakarta.data.repository.*;
import org.utp.web.back.ejb.entities.Almacen;

import java.util.List;

@Repository
public interface AlmacenRepository extends CrudRepository<Almacen, Integer> {

    @Query("SELECT a FROM Almacen a WHERE a.tienda.id = :idTienda")
    List<Almacen> listarPorIdTienda(Integer idTienda);

    @Insert
    Almacen insertar(Almacen entidad);

    @Update
    Almacen actualizar(Almacen entidad);

}

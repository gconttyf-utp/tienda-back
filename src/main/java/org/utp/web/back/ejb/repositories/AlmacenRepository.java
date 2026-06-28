package org.utp.web.back.ejb.repositories;

import jakarta.data.repository.*;
import org.utp.web.back.apirest.models.dto.AlmacenDTO;
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

    @Query("SELECT NEW org.utp.web.back.apirest.models.dto.AlmacenDTO(a.tienda.id, a.producto.id, SUM(a.cantidad)) " +
            "FROM Almacen a " +
            "WHERE a.tienda.id = :idTienda " +
            "GROUP BY a.tienda.id, a.producto.id")
    List<AlmacenDTO> listarPorIdTiendaAcumulado(Integer idTienda);

}

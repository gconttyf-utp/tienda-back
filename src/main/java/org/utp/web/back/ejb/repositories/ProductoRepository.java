package org.utp.web.back.ejb.repositories;

import java.util.Collection;
import java.util.List;

import jakarta.data.repository.*;
import org.utp.web.back.ejb.entities.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Integer>{

    @Query("SELECT p FROM Producto p WHERE p.categoria.id = :idCategoria")
    List<Producto> listarPorIdCategoria(Integer idCategoria);

    @Query("SELECT p FROM Producto p WHERE p.categoria.id = :idCategoria AND p.marca.id = :idMarca")
    List<Producto> listarPorIdCategoriaAndMarca(Integer idCategoria, Integer idMarca);

    @Query("SELECT o FROM Producto o WHERE o.categoria.id = :categoria AND o.estado in (:estados)")
    List<Producto> findByCategoriaIdAndEstadoIn(Integer categoria, Collection<Integer> estados);

    @Query("SELECT o FROM Producto o WHERE o.marca.id = :marca AND o.estado in (:estados)")
    List<Producto> findByMarcaIdAndEstadoIn(Integer marca, Collection<Integer> estados);

    @Query("SELECT o FROM Producto o WHERE o.categoria.id = :categoria AND o.marca.id = :marca AND o.estado in (:estados)")
    List<Producto> findByCategoriaIdAndMarcaIdAndEstadoIn(Integer categoria, Integer marca, Collection<Integer> estados);

    @Insert
    Producto insertar(Producto entidad);

    @Update
    Producto actualizar(Producto entidad);

}

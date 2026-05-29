package org.utp.web.back.ejb.repositories;

import java.util.Collection;
import java.util.List;

import jakarta.data.repository.*;
import org.utp.web.back.ejb.entities.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Integer>{

    @Query("SELECT c FROM Categoria c WHERE c.grupo.id = :idGrupo")
    List<Categoria> listarPorIdGrupo(Integer idGrupo);

    @Query("SELECT o FROM Categoria o WHERE o.grupo.id = :idGrupo AND o.estado in (:estados)")
    List<Categoria> findByGrupoIdAndEstadoIn(Integer idGrupo, Collection<Integer> estados);

    @Insert
    Categoria insertar(Categoria entidad);

    @Update
    Categoria actualizar(Categoria entidad);

}

package org.utp.web.back.ejb.repositories;

import java.util.Collection;
import java.util.List;

import jakarta.data.repository.*;
import org.utp.web.back.ejb.entities.Grupo;

@Repository
public interface GrupoRepository extends CrudRepository<Grupo, Integer> {

    @Query("SELECT g FROM Grupo g WHERE g.departamento.id = :idDep")
    List<Grupo> listarPorIdDepartamento(Integer idDep);

    @Query("SELECT o FROM Grupo o WHERE o.departamento.id = :codDepartamento AND o.estado in (:estados)")
    List<Grupo> findByDepartamentoIdAndEstadoIn(Integer codDepartamento, Collection<Integer> estados);

    @Insert
    Grupo insertar(Grupo entidad);

    @Update
    Grupo actualizar(Grupo entidad);

}
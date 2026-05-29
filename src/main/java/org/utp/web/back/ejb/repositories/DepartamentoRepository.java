package org.utp.web.back.ejb.repositories;

import java.util.Collection;
import java.util.List;

import jakarta.data.repository.*;
import org.utp.web.back.ejb.entities.Departamento;

@Repository
public interface DepartamentoRepository extends CrudRepository<Departamento, Integer> {

    @Find
    List<Departamento> listarTodos();

    @Query("SELECT o FROM Departamento o WHERE o.estado in (:estados)")
    List<Departamento> findByEstadoIn(Collection<Integer> estados);

    @Insert
    Departamento insertar(Departamento entidad);

    @Update
    Departamento actualizar(Departamento entidad);

}

package org.utp.web.back.ejb.repositories;

import jakarta.data.repository.*;
import org.utp.web.back.ejb.entities.Usuario;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    @Find
    Optional<Usuario> findByUsuarioAndEstado(String usuario, Integer estado);

    @Query("SELECT o FROM Usuario o WHERE o.estado in (:estados)")
    List<Usuario> findByEstadoIn(Collection<Integer> estados);

    @Insert
    Usuario insertar(Usuario entidad);

    @Update
    Usuario actualizar(Usuario entidad);

}

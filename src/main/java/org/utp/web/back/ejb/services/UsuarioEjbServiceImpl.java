package org.utp.web.back.ejb.services;

import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.inject.Inject;
import org.utp.web.back.ejb.entities.Usuario;
import org.utp.web.back.ejb.repositories.UsuarioRepository;

import java.util.List;

@Stateless
public class UsuarioEjbServiceImpl implements UsuarioEjbService {

    @Inject
    private UsuarioRepository repository;

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Usuario> listado(List<Integer> estados) {
        return repository.findByEstadoIn(estados);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Usuario encontrarId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Usuario save(Integer id, Usuario oDTO) {
        if ( id == null || id == 0){
            return repository.insertar(oDTO);
        } else {
            Usuario oBD = repository.findById(id).orElse(null);
            if ( oBD != null ){
                oBD.setNombres(oDTO.getNombres());
                oBD.setApellidos(oDTO.getApellidos());
                oBD.setRol(oDTO.getRol());
                oBD.setEstado(oDTO.getEstado());
                return repository.actualizar(oBD);
            }
            return null;
        }
    }

    @Override
    public Integer estadoCero(Integer id) {
        Usuario oBD = repository.findById(id).orElse(null);

        if ( oBD != null ) {
            oBD.setEstado(0);
            repository.actualizar(oBD);
            return 1;
        }
        return 0;
    }

    @Override
    public Integer actualizarClave(Integer id, String newClave) {
        Usuario oBD = repository.findById(id).orElse(null);

        if ( oBD != null ) {
            oBD.setClave( newClave );
            repository.actualizar(oBD);
            return 1;
        }
        return 0;
    }

}

package org.utp.web.back.ejb.services;

import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.inject.Inject;
import org.utp.web.back.apirest.models.dto.UsuarioDTO;
import org.utp.web.back.apirest.models.mappers.UsuarioMapper;
import org.utp.web.back.apirest.security.DatabaseIdentityStore;
import org.utp.web.back.ejb.entities.Usuario;
import org.utp.web.back.ejb.repositories.UsuarioRepository;

import java.util.List;

@Stateless
public class UsuarioEjbServiceImpl implements UsuarioEjbService {

    @Inject
    private DatabaseIdentityStore identityStore;

    @Inject
    private UsuarioRepository repository;

    @Inject
    private UsuarioMapper mapper;

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<UsuarioDTO> listado(List<Integer> estados) {
        return mapper.toDTOList( repository.findByEstadoIn(estados) );
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public UsuarioDTO encontrarId(Integer id) {
        return mapper.toDTO( repository.findById(id).orElse(null) );
    }

    @Override
    public UsuarioDTO save(Integer id, UsuarioDTO oDTO) {
        if ( id == null || id == 0){
            oDTO.setClave( identityStore.encode( oDTO.getClave() ) );
            return mapper.toDTO( repository.insertar( mapper.toEntity( oDTO ) ) );
        } else {
            UsuarioDTO oBD = mapper.toDTO( repository.findById(id).orElse(null) );
            if ( oBD != null ){
                oBD.setNombres(oDTO.getNombres());
                oBD.setApellidos(oDTO.getApellidos());
                oBD.setRolId( oDTO.getRolId() );
                oBD.setEstado(oDTO.getEstado());
                return mapper.toDTO( repository.actualizar( mapper.toEntity( oBD ) ) );
            }
            return null;
        }
    }

    @Override
    public Integer estadoCero(Integer id) {
        Usuario oBD = repository.findById(id).orElse(null);

        if ( oBD != null ) {
            if ( oBD.getEstado() == 1 )
                oBD.setEstado(0);
            else
                oBD.setEstado(1);
            repository.actualizar(oBD);
            return 1;
        }
        return 0;
    }

    @Override
    public Integer actualizarClave(Integer id, String newClave) {
        Usuario oBD = repository.findById(id).orElse(null);

        if ( oBD != null ) {
            oBD.setClave( identityStore.encode( newClave ) );
            repository.actualizar( oBD );
            return 1;
        }
        return 0;
    }

}

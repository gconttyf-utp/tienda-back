package org.utp.web.back.ejb.services;

import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.inject.Inject;
import org.utp.web.back.apirest.models.dto.ClienteDTO;
import org.utp.web.back.apirest.models.mappers.ClienteMapper;
import org.utp.web.back.apirest.security.DatabaseIdentityStore;
import org.utp.web.back.ejb.entities.Cliente;
import org.utp.web.back.ejb.repositories.ClienteRepository;

import java.util.List;

@Stateless
public class ClienteEjbServiceImpl implements ClienteEjbService {

    @Inject
    private ClienteRepository repository;

    @Inject
    private ClienteMapper mapper;

    @Inject
    private DatabaseIdentityStore identityStore;

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<ClienteDTO> listado(List<Integer> estados) {
        return mapper.toDTOList( repository.findByEstadoIn(estados) );
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public ClienteDTO encontrarId(Integer id) {
        return mapper.toDTO( repository.findById(id).orElse(null) );
    }

    @Override
    public ClienteDTO save(Integer id, ClienteDTO oDTO) {
        if ( id == null || id == 0){
            //oDTO.setClave( passwordEncoder.encode( oDTO.getClave() ) );
            //return mapper.toDTO(repository.save(mapper.toEntity(oDTO)));
            return null;
        } else {
            ClienteDTO oBD = mapper.toDTO( repository.findById(id).orElse(null) );
            if ( oBD != null ){
                oBD.setNombres(oDTO.getNombres());
                oBD.setApellidos(oDTO.getApellidos());
                oBD.setEstado(oDTO.getEstado());
                return mapper.toDTO( repository.actualizar( mapper.toEntity( oBD ) ) );
            }
            return null;
        }
    }

    @Override
    public Integer estadoCero(Integer id) {
        Cliente oBD = repository.findById(id).orElse(null);

        if ( oBD != null ) {
            //repository.deleteById(oBD.getId());
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
        Cliente oBD = repository.findById(id).orElse(null);

        if ( oBD != null ) {
            oBD.setClave( identityStore.encode( newClave ) );
            repository.actualizar(oBD);
            return 1;
        }
        return 0;
    }

}

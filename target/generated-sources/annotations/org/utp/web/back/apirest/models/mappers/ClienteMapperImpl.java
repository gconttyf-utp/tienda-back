package org.utp.web.back.apirest.models.mappers;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.utp.web.back.apirest.models.dto.ClienteDTO;
import org.utp.web.back.ejb.entities.Cliente;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-03T03:22:11-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@ApplicationScoped
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public Cliente toEntity(ClienteDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setEstado( dto.getEstado() );
        if ( dto.getId() != null ) {
            cliente.setId( dto.getId() );
        }
        cliente.setCorreo( dto.getCorreo() );
        cliente.setClave( dto.getClave() );
        cliente.setNombres( dto.getNombres() );
        cliente.setApellidos( dto.getApellidos() );

        return cliente;
    }

    @Override
    public ClienteDTO toDTO(Cliente entity) {
        if ( entity == null ) {
            return null;
        }

        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setId( entity.getId() );
        clienteDTO.setCorreo( entity.getCorreo() );
        clienteDTO.setClave( entity.getClave() );
        clienteDTO.setNombres( entity.getNombres() );
        clienteDTO.setApellidos( entity.getApellidos() );
        clienteDTO.setEstado( entity.getEstado() );

        return clienteDTO;
    }

    @Override
    public List<ClienteDTO> toDTOList(List<Cliente> clientes) {
        if ( clientes == null ) {
            return null;
        }

        List<ClienteDTO> list = new ArrayList<ClienteDTO>( clientes.size() );
        for ( Cliente cliente : clientes ) {
            list.add( toDTO( cliente ) );
        }

        return list;
    }

    @Override
    public List<Cliente> toEntityList(List<ClienteDTO> clienteDTOs) {
        if ( clienteDTOs == null ) {
            return null;
        }

        List<Cliente> list = new ArrayList<Cliente>( clienteDTOs.size() );
        for ( ClienteDTO clienteDTO : clienteDTOs ) {
            list.add( toEntity( clienteDTO ) );
        }

        return list;
    }
}

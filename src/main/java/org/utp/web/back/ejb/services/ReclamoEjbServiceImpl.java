package org.utp.web.back.ejb.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utp.web.back.apirest.models.dto.ClienteDTO;
import org.utp.web.back.apirest.models.dto.ReclamoDTO;
import org.utp.web.back.apirest.models.mappers.ClienteMapper;
import org.utp.web.back.apirest.models.mappers.ReclamoMapper;
import org.utp.web.back.ejb.entities.enums.EstadoReclamo;
import org.utp.web.back.ejb.repositories.ReclamoRepository;

import java.util.List;

@Stateless
public class ReclamoEjbServiceImpl implements  ReclamoEjbService {

    @Inject
    private ReclamoRepository repository;

    @Inject
    private ReclamoMapper mapper;

    @Inject
    private ClienteMapper mapperCliente;

    @Override
    public ReclamoDTO save(Integer id, ReclamoDTO oDTO) {
        if ( id == null || id == 0){
            return mapper.toDTO( repository.insertar( mapper.toEntity( oDTO ) ) );
        } else {
            ReclamoDTO oBD = mapper.toDTO( repository.findById(id).orElse(null) );
            if ( oBD != null ){
                return mapper.toDTO( repository.actualizar( mapper.toEntity( oBD ) ) );
            }
            return null;
        }
    }

    @Override
    public ReclamoDTO encontrarID(Integer id) {
        return repository.findById(id).map( mapper::toDTO ).orElse(null);
    }

    @Override
    public List<ReclamoDTO> listarTodos() {
        return mapper.toDTOList( repository.findAll().toList() );
    }

    @Override
    public List<ReclamoDTO> listarPorCliente(Integer clienteId) {
        return mapper.toDTOList( repository.findByClienteId( clienteId ) );
    }

    @Override
    public List<ReclamoDTO> listarPorEstado(EstadoReclamo estado) {
        return mapper.toDTOList( repository.findByEstado( estado ) );
    }

    @Override
    public List<ClienteDTO> listarReclamosPorClientesPendientes() {
        return mapperCliente.toDTOList( repository.findClientesConReclamosPendientes() );
    }

}

package org.utp.web.back.ejb.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utp.web.back.apirest.models.dto.ClienteDTO;
import org.utp.web.back.apirest.models.dto.ReclamoDTO;
import org.utp.web.back.apirest.models.mappers.ClienteMapper;
import org.utp.web.back.apirest.models.mappers.ReclamoMapper;
import org.utp.web.back.ejb.entities.Reclamo;
import org.utp.web.back.ejb.entities.enums.EstadoReclamo;
import org.utp.web.back.ejb.repositories.ReclamoRepository;

import java.time.LocalDateTime;
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
            oDTO.setFechaCreacion( LocalDateTime.now() );
            oDTO.setEstado( EstadoReclamo.PENDIENTE );
            return mapper.toDTO( repository.insertar( mapper.toEntity( oDTO ) ) );
        } else {
            System.out.println("ID = " + id + " oDTO = " + oDTO);

            Reclamo reclamo = repository.findById(id)
                    .orElseThrow( () -> new IllegalArgumentException( "Reclamo no encontrado" ) );

            reclamo.setComentarioRespuesta( oDTO.getComentarioRespuesta() );
            reclamo.setFechaAtencion( LocalDateTime.now() );
            reclamo.setEstado( EstadoReclamo.ATENDIDO );

            repository.actualizar( reclamo );

            return repository.findByIdWithRelations(id).map( mapper::toDTO ).orElse(null);
        }
    }

    @Override
    public ReclamoDTO encontrarID(Integer id) {
        return repository.findByIdWithRelations(id).map( mapper::toDTO ).orElse(null);
    }

    @Override
    public List<ReclamoDTO> listarTodos() {
        return mapper.toDTOList( repository.findTodosWithRelations() );
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

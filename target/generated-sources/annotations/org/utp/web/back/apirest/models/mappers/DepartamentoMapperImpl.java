package org.utp.web.back.apirest.models.mappers;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.utp.web.back.apirest.models.dto.DepartamentoDTO;
import org.utp.web.back.ejb.entities.Departamento;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-03T03:50:42-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@ApplicationScoped
public class DepartamentoMapperImpl implements DepartamentoMapper {

    @Override
    public Departamento toEntity(DepartamentoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Departamento departamento = new Departamento();

        if ( dto.getEstado() != null ) {
            departamento.setEstado( dto.getEstado() );
        }
        else {
            departamento.setEstado( 1 );
        }
        departamento.setId( dto.getId() );
        departamento.setNombre( dto.getNombre() );

        return departamento;
    }

    @Override
    public DepartamentoDTO toDTO(Departamento entity) {
        if ( entity == null ) {
            return null;
        }

        DepartamentoDTO departamentoDTO = new DepartamentoDTO();

        departamentoDTO.setId( entity.getId() );
        departamentoDTO.setNombre( entity.getNombre() );
        departamentoDTO.setEstado( entity.getEstado() );

        return departamentoDTO;
    }

    @Override
    public List<DepartamentoDTO> toDTOList(List<Departamento> entities) {
        if ( entities == null ) {
            return null;
        }

        List<DepartamentoDTO> list = new ArrayList<DepartamentoDTO>( entities.size() );
        for ( Departamento departamento : entities ) {
            list.add( toDTO( departamento ) );
        }

        return list;
    }
}

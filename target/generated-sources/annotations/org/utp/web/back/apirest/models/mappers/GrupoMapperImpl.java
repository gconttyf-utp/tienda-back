package org.utp.web.back.apirest.models.mappers;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.utp.web.back.apirest.models.dto.GrupoDTO;
import org.utp.web.back.ejb.entities.Departamento;
import org.utp.web.back.ejb.entities.Grupo;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-29T12:22:05-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@ApplicationScoped
public class GrupoMapperImpl implements GrupoMapper {

    @Override
    public Grupo toEntity(GrupoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Grupo grupo = new Grupo();

        grupo.setDepartamento( grupoDTOToDepartamento( dto ) );
        if ( dto.getEstado() != null ) {
            grupo.setEstado( dto.getEstado() );
        }
        else {
            grupo.setEstado( 1 );
        }
        grupo.setId( dto.getId() );
        grupo.setNombre( dto.getNombre() );

        return grupo;
    }

    @Override
    public GrupoDTO toDTO(Grupo entity) {
        if ( entity == null ) {
            return null;
        }

        GrupoDTO grupoDTO = new GrupoDTO();

        grupoDTO.setDepartamentoId( entityDepartamentoId( entity ) );
        grupoDTO.setId( entity.getId() );
        grupoDTO.setNombre( entity.getNombre() );
        grupoDTO.setEstado( entity.getEstado() );

        return grupoDTO;
    }

    @Override
    public List<GrupoDTO> toDTOList(List<Grupo> entities) {
        if ( entities == null ) {
            return null;
        }

        List<GrupoDTO> list = new ArrayList<GrupoDTO>( entities.size() );
        for ( Grupo grupo : entities ) {
            list.add( toDTO( grupo ) );
        }

        return list;
    }

    protected Departamento grupoDTOToDepartamento(GrupoDTO grupoDTO) {
        if ( grupoDTO == null ) {
            return null;
        }

        Departamento departamento = new Departamento();

        departamento.setId( grupoDTO.getDepartamentoId() );

        return departamento;
    }

    private Integer entityDepartamentoId(Grupo grupo) {
        if ( grupo == null ) {
            return null;
        }
        Departamento departamento = grupo.getDepartamento();
        if ( departamento == null ) {
            return null;
        }
        Integer id = departamento.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}

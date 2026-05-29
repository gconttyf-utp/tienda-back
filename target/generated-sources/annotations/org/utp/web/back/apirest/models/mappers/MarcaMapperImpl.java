package org.utp.web.back.apirest.models.mappers;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.utp.web.back.apirest.models.dto.MarcaDTO;
import org.utp.web.back.ejb.entities.Marca;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-29T12:22:05-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@ApplicationScoped
public class MarcaMapperImpl implements MarcaMapper {

    @Override
    public Marca toEntity(MarcaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Marca marca = new Marca();

        if ( dto.getEstado() != null ) {
            marca.setEstado( dto.getEstado() );
        }
        else {
            marca.setEstado( 1 );
        }
        marca.setId( dto.getId() );
        marca.setNombre( dto.getNombre() );

        return marca;
    }

    @Override
    public MarcaDTO toDTO(Marca entity) {
        if ( entity == null ) {
            return null;
        }

        MarcaDTO marcaDTO = new MarcaDTO();

        marcaDTO.setId( entity.getId() );
        marcaDTO.setNombre( entity.getNombre() );
        marcaDTO.setEstado( entity.getEstado() );

        return marcaDTO;
    }

    @Override
    public List<MarcaDTO> toDTOList(List<Marca> entities) {
        if ( entities == null ) {
            return null;
        }

        List<MarcaDTO> list = new ArrayList<MarcaDTO>( entities.size() );
        for ( Marca marca : entities ) {
            list.add( toDTO( marca ) );
        }

        return list;
    }
}

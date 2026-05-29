package org.utp.web.back.apirest.models.mappers;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.utp.web.back.apirest.models.dto.TiendaDTO;
import org.utp.web.back.ejb.entities.Tienda;
import org.utp.web.back.ejb.entities.Ubigeo;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-29T12:22:05-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@ApplicationScoped
public class TiendaMapperImpl implements TiendaMapper {

    @Override
    public Tienda toEntity(TiendaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Tienda tienda = new Tienda();

        tienda.setUbigeo( tiendaDTOToUbigeo( dto ) );
        if ( dto.getEstado() != null ) {
            tienda.setEstado( dto.getEstado() );
        }
        else {
            tienda.setEstado( 1 );
        }
        tienda.setId( dto.getId() );
        tienda.setNombre( dto.getNombre() );
        tienda.setDireccion( dto.getDireccion() );
        tienda.setHorario( dto.getHorario() );
        tienda.setTelefono( dto.getTelefono() );
        tienda.setImagenUrl( dto.getImagenUrl() );
        tienda.setLatitud( dto.getLatitud() );
        tienda.setLongitud( dto.getLongitud() );

        return tienda;
    }

    @Override
    public TiendaDTO toDTO(Tienda entity) {
        if ( entity == null ) {
            return null;
        }

        TiendaDTO tiendaDTO = new TiendaDTO();

        tiendaDTO.setCodUbigeo( entityUbigeoCodUbigeo( entity ) );
        tiendaDTO.setId( entity.getId() );
        tiendaDTO.setNombre( entity.getNombre() );
        tiendaDTO.setDireccion( entity.getDireccion() );
        tiendaDTO.setEstado( entity.getEstado() );
        tiendaDTO.setHorario( entity.getHorario() );
        tiendaDTO.setTelefono( entity.getTelefono() );
        tiendaDTO.setImagenUrl( entity.getImagenUrl() );
        tiendaDTO.setLatitud( entity.getLatitud() );
        tiendaDTO.setLongitud( entity.getLongitud() );

        return tiendaDTO;
    }

    @Override
    public List<TiendaDTO> toDTOList(List<Tienda> entities) {
        if ( entities == null ) {
            return null;
        }

        List<TiendaDTO> list = new ArrayList<TiendaDTO>( entities.size() );
        for ( Tienda tienda : entities ) {
            list.add( toDTO( tienda ) );
        }

        return list;
    }

    protected Ubigeo tiendaDTOToUbigeo(TiendaDTO tiendaDTO) {
        if ( tiendaDTO == null ) {
            return null;
        }

        Ubigeo ubigeo = new Ubigeo();

        ubigeo.setCodUbigeo( tiendaDTO.getCodUbigeo() );

        return ubigeo;
    }

    private String entityUbigeoCodUbigeo(Tienda tienda) {
        if ( tienda == null ) {
            return null;
        }
        Ubigeo ubigeo = tienda.getUbigeo();
        if ( ubigeo == null ) {
            return null;
        }
        String codUbigeo = ubigeo.getCodUbigeo();
        if ( codUbigeo == null ) {
            return null;
        }
        return codUbigeo;
    }
}

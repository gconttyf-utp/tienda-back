package org.utp.web.back.apirest.models.mappers;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.utp.web.back.apirest.models.dto.RolDTO;
import org.utp.web.back.ejb.entities.Rol;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-03T03:50:43-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@ApplicationScoped
public class RolMapperImpl implements RolMapper {

    @Override
    public Rol toEntity(RolDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Rol rol = new Rol();

        if ( dto.getEstado() != null ) {
            rol.setEstado( dto.getEstado() );
        }
        else {
            rol.setEstado( 1 );
        }
        rol.setId( dto.getId() );
        rol.setDescripcion( dto.getDescripcion() );

        return rol;
    }

    @Override
    public RolDTO toDTO(Rol entity) {
        if ( entity == null ) {
            return null;
        }

        RolDTO rolDTO = new RolDTO();

        rolDTO.setId( entity.getId() );
        rolDTO.setDescripcion( entity.getDescripcion() );
        rolDTO.setEstado( entity.getEstado() );

        return rolDTO;
    }

    @Override
    public List<RolDTO> toDTOList(List<Rol> entities) {
        if ( entities == null ) {
            return null;
        }

        List<RolDTO> list = new ArrayList<RolDTO>( entities.size() );
        for ( Rol rol : entities ) {
            list.add( toDTO( rol ) );
        }

        return list;
    }
}

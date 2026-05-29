package org.utp.web.back.apirest.models.mappers;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.utp.web.back.ejb.entities.Rol;
import org.utp.web.back.apirest.models.dto.RolDTO;

import java.util.List;

@Mapper(componentModel = "cdi", builder = @Builder(disableBuilder = true))
public interface RolMapper {

    @Mapping(target = "estado", defaultValue = "1")
    Rol toEntity(RolDTO dto);

    RolDTO toDTO(Rol entity);

    List<RolDTO> toDTOList(List<Rol> entities);
    
}

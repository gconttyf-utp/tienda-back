package org.utp.web.back.apirest.models.mappers;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.utp.web.back.ejb.entities.Usuario;
import org.utp.web.back.apirest.models.dto.UsuarioDTO;

import java.util.List;

@Mapper(componentModel = "cdi", builder = @Builder(disableBuilder = true))
public interface UsuarioMapper {

    @Mapping(source = "rolId", target = "rol.id")
    @Mapping(target = "estado", defaultValue = "1")
    Usuario toEntity(UsuarioDTO dto);

    @Mapping(source = "rol.id", target = "rolId")
    UsuarioDTO toDTO(Usuario entity);

    List<UsuarioDTO> toDTOList(List<Usuario> entities);
    
}

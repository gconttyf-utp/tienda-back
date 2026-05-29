package org.utp.web.back.apirest.models.mappers;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.utp.web.back.ejb.entities.Tienda;
import org.utp.web.back.apirest.models.dto.TiendaDTO;

import java.util.List;

@Mapper(componentModel = "cdi", builder = @Builder(disableBuilder = true))
public interface TiendaMapper {

    @Mapping(source = "codUbigeo", target = "ubigeo.codUbigeo")
    @Mapping(target = "estado", defaultValue = "1")
    Tienda toEntity(TiendaDTO dto);

    @Mapping(source = "ubigeo.codUbigeo", target = "codUbigeo")
    TiendaDTO toDTO(Tienda entity);

    List<TiendaDTO> toDTOList(List<Tienda> entities);

}

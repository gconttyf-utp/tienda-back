package org.utp.web.back.apirest.models.mappers;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.utp.web.back.ejb.entities.Marca;
import org.utp.web.back.apirest.models.dto.MarcaDTO;

import java.util.List;

@Mapper(componentModel = "cdi", builder = @Builder(disableBuilder = true))
public interface MarcaMapper {

    @Mapping(target = "estado", defaultValue = "1")
    Marca toEntity(MarcaDTO dto);

    MarcaDTO toDTO(Marca entity);

    List<MarcaDTO> toDTOList(List<Marca> entities);
}

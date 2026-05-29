package org.utp.web.back.apirest.models.mappers;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.utp.web.back.ejb.entities.Grupo;
import org.utp.web.back.apirest.models.dto.GrupoDTO;

import java.util.List;

@Mapper(componentModel = "cdi", builder = @Builder(disableBuilder = true))
public interface GrupoMapper {

    @Mapping(source = "departamentoId", target = "departamento.id")
    @Mapping(target = "estado", defaultValue = "1")
    Grupo toEntity(GrupoDTO dto);

    @Mapping(source = "departamento.id", target = "departamentoId")
    GrupoDTO toDTO(Grupo entity);

    List<GrupoDTO> toDTOList(List<Grupo> entities);

}

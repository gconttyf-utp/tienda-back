package org.utp.web.back.apirest.models.mappers;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.utp.web.back.ejb.entities.Categoria;
import org.utp.web.back.apirest.models.dto.CategoriaDTO;

import java.util.List;

@Mapper(componentModel = "cdi", builder = @Builder(disableBuilder = true))
public interface CategoriaMapper {

    @Mapping(source = "grupoId", target = "grupo.id")
    @Mapping(target = "estado", defaultValue = "1")
    Categoria toEntity(CategoriaDTO dto);

    @Mapping(source = "grupo.id", target = "grupoId")
    CategoriaDTO toDTO(Categoria entity);

    List<CategoriaDTO> toDTOList(List<Categoria> entities);
}

package org.utp.web.back.apirest.models.mappers;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.utp.web.back.ejb.entities.Departamento;
import org.utp.web.back.apirest.models.dto.DepartamentoDTO;

import java.util.List;

@Mapper(componentModel = "cdi", builder = @Builder(disableBuilder = true))
public interface DepartamentoMapper {

    @Mapping(target = "estado", defaultValue = "1")
    Departamento toEntity(DepartamentoDTO dto);

    DepartamentoDTO toDTO(Departamento entity);

    List<DepartamentoDTO> toDTOList(List<Departamento> entities);
}

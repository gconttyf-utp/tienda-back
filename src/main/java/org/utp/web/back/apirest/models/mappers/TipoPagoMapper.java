package org.utp.web.back.apirest.models.mappers;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.utp.web.back.apirest.models.dto.TipoPagoDTO;
import org.utp.web.back.ejb.entities.TipoPago;

import java.util.List;

@Mapper(componentModel = "cdi", builder = @Builder(disableBuilder = true))
public interface TipoPagoMapper {

    @Mapping(target = "estado", defaultValue = "1")
    TipoPago toEntity(TipoPagoDTO dto);

    TipoPagoDTO toDTO(TipoPago entity);

    List<TipoPagoDTO> toDTOList(List<TipoPago> entities);

}

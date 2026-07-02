package org.utp.web.back.apirest.models.mappers;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.utp.web.back.apirest.models.dto.ReclamoDTO;
import org.utp.web.back.ejb.entities.Reclamo;

import java.util.List;

@Mapper(componentModel = "cdi", builder = @Builder(disableBuilder = true))
public interface ReclamoMapper {

    @Mapping(source = "clienteID", target = "cliente.id")
    @Mapping(source = "pedidoID", target = "pedido.id")
    @Mapping(target = "estado", defaultValue = "PENDIENTE")
    Reclamo toEntity(ReclamoDTO dto);

    @Mapping(source = "cliente.id", target = "clienteID")
    @Mapping(source = "pedido.id", target = "pedidoID")
    ReclamoDTO toDTO(Reclamo entity);

    List<ReclamoDTO> toDTOList(List<Reclamo> entities);
}

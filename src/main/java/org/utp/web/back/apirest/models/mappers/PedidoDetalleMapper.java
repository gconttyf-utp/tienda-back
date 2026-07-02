package org.utp.web.back.apirest.models.mappers;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.utp.web.back.apirest.models.dto.PedidoDetalleDTO;
import org.utp.web.back.ejb.entities.PedidoDetalle;

import java.util.List;

@Mapper(componentModel = "cdi", builder = @Builder(disableBuilder = true))
public interface PedidoDetalleMapper {

    @Mapping(source = "pedidoID", target = "pedido.id")
    @Mapping(source = "productoID", target = "producto.id")
    PedidoDetalle toEntity(PedidoDetalleDTO dto);

    @Mapping(source = "pedido.id", target = "pedidoID")
    @Mapping(source = "producto.id", target = "productoID")
    PedidoDetalleDTO toDTO(PedidoDetalle entity);

    List<PedidoDetalleDTO> toDTOList(List<PedidoDetalle> entities);
}

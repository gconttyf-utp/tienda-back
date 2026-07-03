package org.utp.web.back.apirest.models.mappers;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.utp.web.back.apirest.models.dto.PedidoDTO;
import org.utp.web.back.ejb.entities.Pedido;

import java.util.List;

@Mapper(componentModel = "cdi", uses = {PedidoDetalleMapper.class}, builder = @Builder(disableBuilder = true))
public interface PedidoMapper {

    @Mapping(source = "clienteID", target = "cliente.id")
    @Mapping(source = "tiendaID", target = "tienda.id")
    @Mapping(target = "estado", defaultValue = "PENDIENTE_PAGO")
    Pedido toEntity(PedidoDTO dto);

    @Mapping(source = "cliente.id", target = "clienteID")
    @Mapping(source = "tienda.id", target = "tiendaID")
    PedidoDTO toDTO(Pedido entity);

    List<PedidoDTO> toDTOList(List<Pedido> entities);
}

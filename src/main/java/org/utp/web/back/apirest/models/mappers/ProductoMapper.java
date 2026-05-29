package org.utp.web.back.apirest.models.mappers;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.utp.web.back.ejb.entities.Producto;
import org.utp.web.back.apirest.models.dto.ProductoDTO;

import java.util.List;

@Mapper(componentModel = "cdi", builder = @Builder(disableBuilder = true))
public interface ProductoMapper {

    @Mapping(source = "marcaID", target = "marca.id")
    @Mapping(source = "categoriaID", target = "categoria.id")
    @Mapping(target = "estado", defaultValue = "1")
    Producto toEntity(ProductoDTO dto);

    @Mapping(source = "marca.id", target = "marcaID")
    @Mapping(source = "categoria.id", target = "categoriaID")
    ProductoDTO toDTO(Producto entity);

    List<ProductoDTO> toDTOList(List<Producto> entities);
}

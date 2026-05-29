package org.utp.web.back.apirest.models.mappers;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.utp.web.back.apirest.models.dto.AlmacenDTO;
import org.utp.web.back.ejb.entities.Almacen;

import java.util.List;

@Mapper(componentModel = "cdi", builder = @Builder(disableBuilder = true))
public interface AlmacenMapper {

    @Mapping(source = "tiendaId", target = "tienda.id")
    @Mapping(source = "productoId", target = "producto.id")
    Almacen toEntity(AlmacenDTO dto);

    @Mapping(source = "tienda.id", target = "tiendaId")
    @Mapping(source = "producto.id", target = "productoId")
    AlmacenDTO toDTO(Almacen entity);

    List<AlmacenDTO> toDTOList(List<Almacen> entity);

}

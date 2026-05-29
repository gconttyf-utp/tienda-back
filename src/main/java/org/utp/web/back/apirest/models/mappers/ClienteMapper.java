package org.utp.web.back.apirest.models.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.utp.web.back.ejb.entities.Cliente;
import org.utp.web.back.apirest.models.dto.ClienteDTO;

import java.util.List;

import org.mapstruct.Builder;

@Mapper(componentModel = "cdi", builder = @Builder(disableBuilder = true))
public interface ClienteMapper {

    @Mapping(target = "estado", defaultValue = "1") // Puedes forzar un valor por defecto al crear
    Cliente toEntity(ClienteDTO dto);

    //@Mapping(target = "clave", ignore = true)
    ClienteDTO toDTO(Cliente entity);

    List<ClienteDTO> toDTOList(List<Cliente> clientes);

    List<Cliente> toEntityList(List<ClienteDTO> clienteDTOs);

    //@Mapping(source = "pass", target = "clave")
    //@Mapping(target = "id", ignore = true) // Ignoramos el ID para no sobrescribir la llave primaria accidentalmente
    //void updateEntityFromDTO(ClienteDTO dto, @org.mapstruct.MappingTarget Cliente entity);

}

package org.utp.web.back.apirest.models.mappers;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.utp.web.back.apirest.models.dto.AlmacenDTO;
import org.utp.web.back.ejb.entities.Almacen;
import org.utp.web.back.ejb.entities.Producto;
import org.utp.web.back.ejb.entities.Tienda;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-29T12:22:05-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@ApplicationScoped
public class AlmacenMapperImpl implements AlmacenMapper {

    @Override
    public Almacen toEntity(AlmacenDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Almacen almacen = new Almacen();

        almacen.setTienda( almacenDTOToTienda( dto ) );
        almacen.setProducto( almacenDTOToProducto( dto ) );
        almacen.setId( dto.getId() );
        almacen.setFechaIngreso( dto.getFechaIngreso() );
        almacen.setCantidad( dto.getCantidad() );

        return almacen;
    }

    @Override
    public AlmacenDTO toDTO(Almacen entity) {
        if ( entity == null ) {
            return null;
        }

        AlmacenDTO almacenDTO = new AlmacenDTO();

        almacenDTO.setTiendaId( entityTiendaId( entity ) );
        almacenDTO.setProductoId( entityProductoId( entity ) );
        almacenDTO.setId( entity.getId() );
        almacenDTO.setFechaIngreso( entity.getFechaIngreso() );
        almacenDTO.setCantidad( entity.getCantidad() );

        return almacenDTO;
    }

    @Override
    public List<AlmacenDTO> toDTOList(List<Almacen> entity) {
        if ( entity == null ) {
            return null;
        }

        List<AlmacenDTO> list = new ArrayList<AlmacenDTO>( entity.size() );
        for ( Almacen almacen : entity ) {
            list.add( toDTO( almacen ) );
        }

        return list;
    }

    protected Tienda almacenDTOToTienda(AlmacenDTO almacenDTO) {
        if ( almacenDTO == null ) {
            return null;
        }

        Tienda tienda = new Tienda();

        tienda.setId( almacenDTO.getTiendaId() );

        return tienda;
    }

    protected Producto almacenDTOToProducto(AlmacenDTO almacenDTO) {
        if ( almacenDTO == null ) {
            return null;
        }

        Producto producto = new Producto();

        producto.setId( almacenDTO.getProductoId() );

        return producto;
    }

    private Integer entityTiendaId(Almacen almacen) {
        if ( almacen == null ) {
            return null;
        }
        Tienda tienda = almacen.getTienda();
        if ( tienda == null ) {
            return null;
        }
        Integer id = tienda.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Integer entityProductoId(Almacen almacen) {
        if ( almacen == null ) {
            return null;
        }
        Producto producto = almacen.getProducto();
        if ( producto == null ) {
            return null;
        }
        Integer id = producto.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}

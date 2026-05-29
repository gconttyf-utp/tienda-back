package org.utp.web.back.apirest.models.mappers;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.utp.web.back.apirest.models.dto.ProductoDTO;
import org.utp.web.back.ejb.entities.Categoria;
import org.utp.web.back.ejb.entities.Marca;
import org.utp.web.back.ejb.entities.Producto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-29T12:22:06-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@ApplicationScoped
public class ProductoMapperImpl implements ProductoMapper {

    @Override
    public Producto toEntity(ProductoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Producto producto = new Producto();

        producto.setMarca( productoDTOToMarca( dto ) );
        producto.setCategoria( productoDTOToCategoria( dto ) );
        if ( dto.getEstado() != null ) {
            producto.setEstado( dto.getEstado() );
        }
        else {
            producto.setEstado( 1 );
        }
        producto.setId( dto.getId() );
        producto.setDescripcion( dto.getDescripcion() );
        producto.setSku( dto.getSku() );
        producto.setPrecioLista( dto.getPrecioLista() );
        producto.setPrecioOnline( dto.getPrecioOnline() );
        producto.setStock( dto.getStock() );
        producto.setRutaImg( dto.getRutaImg() );
        producto.setSlug( dto.getSlug() );
        producto.setUnidad( dto.getUnidad() );
        producto.setColorPlaceholder( dto.getColorPlaceholder() );
        producto.setDescripcionLarga( dto.getDescripcionLarga() );
        producto.setOferta( dto.getOferta() );
        producto.setDestacado( dto.getDestacado() );
        producto.setCreatedAt( dto.getCreatedAt() );

        return producto;
    }

    @Override
    public ProductoDTO toDTO(Producto entity) {
        if ( entity == null ) {
            return null;
        }

        ProductoDTO productoDTO = new ProductoDTO();

        productoDTO.setMarcaID( entityMarcaId( entity ) );
        productoDTO.setCategoriaID( entityCategoriaId( entity ) );
        productoDTO.setId( entity.getId() );
        productoDTO.setDescripcion( entity.getDescripcion() );
        productoDTO.setSku( entity.getSku() );
        productoDTO.setPrecioLista( entity.getPrecioLista() );
        productoDTO.setPrecioOnline( entity.getPrecioOnline() );
        productoDTO.setStock( entity.getStock() );
        productoDTO.setRutaImg( entity.getRutaImg() );
        productoDTO.setEstado( entity.getEstado() );
        productoDTO.setSlug( entity.getSlug() );
        productoDTO.setUnidad( entity.getUnidad() );
        productoDTO.setColorPlaceholder( entity.getColorPlaceholder() );
        productoDTO.setDescripcionLarga( entity.getDescripcionLarga() );
        productoDTO.setOferta( entity.getOferta() );
        productoDTO.setDestacado( entity.getDestacado() );
        productoDTO.setCreatedAt( entity.getCreatedAt() );

        return productoDTO;
    }

    @Override
    public List<ProductoDTO> toDTOList(List<Producto> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ProductoDTO> list = new ArrayList<ProductoDTO>( entities.size() );
        for ( Producto producto : entities ) {
            list.add( toDTO( producto ) );
        }

        return list;
    }

    protected Marca productoDTOToMarca(ProductoDTO productoDTO) {
        if ( productoDTO == null ) {
            return null;
        }

        Marca marca = new Marca();

        marca.setId( productoDTO.getMarcaID() );

        return marca;
    }

    protected Categoria productoDTOToCategoria(ProductoDTO productoDTO) {
        if ( productoDTO == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setId( productoDTO.getCategoriaID() );

        return categoria;
    }

    private Integer entityMarcaId(Producto producto) {
        if ( producto == null ) {
            return null;
        }
        Marca marca = producto.getMarca();
        if ( marca == null ) {
            return null;
        }
        Integer id = marca.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Integer entityCategoriaId(Producto producto) {
        if ( producto == null ) {
            return null;
        }
        Categoria categoria = producto.getCategoria();
        if ( categoria == null ) {
            return null;
        }
        Integer id = categoria.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}

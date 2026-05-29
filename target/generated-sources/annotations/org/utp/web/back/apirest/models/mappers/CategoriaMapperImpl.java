package org.utp.web.back.apirest.models.mappers;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.utp.web.back.apirest.models.dto.CategoriaDTO;
import org.utp.web.back.ejb.entities.Categoria;
import org.utp.web.back.ejb.entities.Grupo;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-29T12:22:05-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@ApplicationScoped
public class CategoriaMapperImpl implements CategoriaMapper {

    @Override
    public Categoria toEntity(CategoriaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setGrupo( categoriaDTOToGrupo( dto ) );
        if ( dto.getEstado() != null ) {
            categoria.setEstado( dto.getEstado() );
        }
        else {
            categoria.setEstado( 1 );
        }
        categoria.setId( dto.getId() );
        categoria.setNombre( dto.getNombre() );

        return categoria;
    }

    @Override
    public CategoriaDTO toDTO(Categoria entity) {
        if ( entity == null ) {
            return null;
        }

        CategoriaDTO categoriaDTO = new CategoriaDTO();

        categoriaDTO.setGrupoId( entityGrupoId( entity ) );
        categoriaDTO.setId( entity.getId() );
        categoriaDTO.setNombre( entity.getNombre() );
        categoriaDTO.setEstado( entity.getEstado() );

        return categoriaDTO;
    }

    @Override
    public List<CategoriaDTO> toDTOList(List<Categoria> entities) {
        if ( entities == null ) {
            return null;
        }

        List<CategoriaDTO> list = new ArrayList<CategoriaDTO>( entities.size() );
        for ( Categoria categoria : entities ) {
            list.add( toDTO( categoria ) );
        }

        return list;
    }

    protected Grupo categoriaDTOToGrupo(CategoriaDTO categoriaDTO) {
        if ( categoriaDTO == null ) {
            return null;
        }

        Grupo grupo = new Grupo();

        grupo.setId( categoriaDTO.getGrupoId() );

        return grupo;
    }

    private Integer entityGrupoId(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }
        Grupo grupo = categoria.getGrupo();
        if ( grupo == null ) {
            return null;
        }
        Integer id = grupo.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}

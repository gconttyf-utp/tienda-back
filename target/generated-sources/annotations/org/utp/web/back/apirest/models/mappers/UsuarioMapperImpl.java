package org.utp.web.back.apirest.models.mappers;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.utp.web.back.apirest.models.dto.UsuarioDTO;
import org.utp.web.back.ejb.entities.Rol;
import org.utp.web.back.ejb.entities.Usuario;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-29T12:22:05-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@ApplicationScoped
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public Usuario toEntity(UsuarioDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setRol( usuarioDTOToRol( dto ) );
        if ( dto.getEstado() != null ) {
            usuario.setEstado( dto.getEstado() );
        }
        else {
            usuario.setEstado( 1 );
        }
        usuario.setId( dto.getId() );
        usuario.setNombres( dto.getNombres() );
        usuario.setApellidos( dto.getApellidos() );
        usuario.setUsuario( dto.getUsuario() );
        usuario.setClave( dto.getClave() );

        return usuario;
    }

    @Override
    public UsuarioDTO toDTO(Usuario entity) {
        if ( entity == null ) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setRolId( entityRolId( entity ) );
        usuarioDTO.setId( entity.getId() );
        usuarioDTO.setNombres( entity.getNombres() );
        usuarioDTO.setApellidos( entity.getApellidos() );
        usuarioDTO.setUsuario( entity.getUsuario() );
        usuarioDTO.setClave( entity.getClave() );
        usuarioDTO.setEstado( entity.getEstado() );

        return usuarioDTO;
    }

    @Override
    public List<UsuarioDTO> toDTOList(List<Usuario> entities) {
        if ( entities == null ) {
            return null;
        }

        List<UsuarioDTO> list = new ArrayList<UsuarioDTO>( entities.size() );
        for ( Usuario usuario : entities ) {
            list.add( toDTO( usuario ) );
        }

        return list;
    }

    protected Rol usuarioDTOToRol(UsuarioDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        Rol rol = new Rol();

        rol.setId( usuarioDTO.getRolId() );

        return rol;
    }

    private Integer entityRolId(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }
        Rol rol = usuario.getRol();
        if ( rol == null ) {
            return null;
        }
        Integer id = rol.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}

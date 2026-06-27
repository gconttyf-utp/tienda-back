package org.utp.web.back.ejb.services;

import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.inject.Inject;
import org.utp.web.back.apirest.models.dto.AlmacenDTO;
import org.utp.web.back.apirest.models.dto.TiendaDTO;
import org.utp.web.back.apirest.models.mappers.AlmacenMapper;
import org.utp.web.back.apirest.models.mappers.TiendaMapper;
import org.utp.web.back.ejb.entities.Almacen;
import org.utp.web.back.ejb.repositories.AlmacenRepository;
import org.utp.web.back.ejb.repositories.TiendaRepository;

import java.time.LocalDateTime;
import java.util.List;

@Stateless
public class AlmacenEjbServiceImpl implements AlmacenEjbService {

    @Inject
    private AlmacenRepository repository;

    @Inject
    private AlmacenMapper mapper;

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<AlmacenDTO> listado(Integer tienda) {
        return mapper.toDTOList( repository.listarPorIdTienda(tienda) );
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public AlmacenDTO encontrarId(Integer id) {
        return mapper.toDTO( repository.findById(id).orElse(null) );
    }

    @Override
    public AlmacenDTO save(Integer id, AlmacenDTO oDTO) {
        if ( id == null || id == 0){
            System.out.println("Nuevo Registro Almacen");
            if ( oDTO.getFechaIngreso() == null ){
                oDTO.setFechaIngreso( LocalDateTime.now() );
            }
            return mapper.toDTO( repository.insertar( mapper.toEntity( oDTO ) ) );
        } else {
            AlmacenDTO oBD = mapper.toDTO( repository.findById(id).orElse(null) );
            if ( oBD != null ){
                oBD.setTiendaId( oDTO.getTiendaId() );
                oBD.setProductoId( oDTO.getProductoId() );
                oBD.setCantidad( oDTO.getCantidad() );
                return mapper.toDTO( repository.actualizar( mapper.toEntity( oBD ) ) );
            }
            return null;
        }
    }

    @Inject
    private TiendaRepository repositoryTienda;

    @Inject
    private TiendaMapper mapperTienda;

    @Override
    public List<TiendaDTO> listadoTiendasSinAlmacen() {
        return mapperTienda.toDTOList( repositoryTienda.findTiendasSinAlmacen() );
    }

    @Override
    public List<TiendaDTO> listadoTiendasConAlmacen() {
        return mapperTienda.toDTOList( repositoryTienda.findTiendasConAlmacen() );
    }

}

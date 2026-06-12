package org.utp.web.back.ejb.services;

import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.inject.Inject;
import org.utp.web.back.apirest.models.dto.TiendaDTO;
import org.utp.web.back.apirest.models.mappers.TiendaMapper;
import org.utp.web.back.ejb.entities.Tienda;
import org.utp.web.back.ejb.repositories.TiendaRepository;

import java.util.List;

@Stateless
public class TiendaEjbServiceImpl implements TiendaEjbService {

    @Inject
    private TiendaRepository repository;

    @Inject
    private TiendaMapper mapper;

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<TiendaDTO> listado(List<Integer> estados) {
        return mapper.toDTOList( repository.findByEstadoIn(estados) );
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<TiendaDTO> listadoUbigeo(String ubigeo, List<Integer> estados) {
        return mapper.toDTOList( repository.findByUbigeoCodUbigeoAndEstadoIn(ubigeo, estados) );
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public TiendaDTO encontrarId(Integer id) {
        return mapper.toDTO( repository.findById(id).orElse(null) );
    }

    @Override
    public TiendaDTO save(Integer id, TiendaDTO oDTO) {
        if ( id == null || id == 0){
            return mapper.toDTO( repository.insertar( mapper.toEntity( oDTO ) ) );
        } else {
            TiendaDTO oBD = mapper.toDTO( repository.findById(id).orElse(null) );

            if ( oBD != null ){
                oBD.setNombre(oDTO.getNombre());
                oBD.setDireccion(oDTO.getDireccion());
                oBD.setCodUbigeo( oDTO.getCodUbigeo() );
                oBD.setHorario( oDTO.getHorario() );
                oBD.setLatitud( oDTO.getLatitud() );
                oBD.setLongitud( oDTO.getLongitud() );
                oBD.setTelefono( oDTO.getTelefono() );
                oBD.setImagenUrl( oDTO.getImagenUrl() );
                oBD.setEstado(oDTO.getEstado());
                return mapper.toDTO( repository.actualizar( mapper.toEntity( oBD ) ) );
            }
            return null;
        }
    }

    @Override
    public Integer estadoCero(Integer id) {
        Tienda oBD = repository.findById(id).orElse(null);

        if ( oBD != null ) {
            //repository.deleteById(oBD.getId());
            if ( oBD.getEstado() == 1 )
                oBD.setEstado(0);
            else
                oBD.setEstado(1);
            repository.actualizar(oBD);
            return 1;
        }
        return 0;
    }

}

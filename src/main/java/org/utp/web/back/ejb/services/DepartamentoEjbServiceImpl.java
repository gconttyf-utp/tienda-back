package org.utp.web.back.ejb.services;

import java.util.List;

import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import org.utp.web.back.apirest.models.dto.DepartamentoDTO;
import org.utp.web.back.apirest.models.mappers.DepartamentoMapper;
import org.utp.web.back.ejb.entities.Departamento;
import org.utp.web.back.ejb.repositories.DepartamentoRepository;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class DepartamentoEjbServiceImpl implements DepartamentoEjbService {

    @Inject
    private DepartamentoRepository repository;

    @Inject
    private DepartamentoMapper mapper;

    @Override
    public List<Departamento> listarTodos() {
        //return repository.listarTodos();
        return repository.findAll().toList();
    }

    @Override
    public Departamento buscarDepartamento(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    // ESTE ES EL EQUIVALENTE EXACTO A @Transactional(readOnly = true) EN EJB
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<DepartamentoDTO> listarDepartamentos(List<Integer> estados) {
        return mapper.toDTOList(repository.findByEstadoIn(estados));
    }

    @Override
    public DepartamentoDTO encontrarDepartamento(Integer id) {
        return mapper.toDTO( repository.findById(id).orElse(null) );
    }

    @Override
    public DepartamentoDTO salvarDepartamento(Integer id, DepartamentoDTO departamento) {
        if ( id == null || id == 0){
            return mapper.toDTO( repository.insertar( mapper.toEntity( departamento ) ) );
        } else {
            DepartamentoDTO departamentoBD = mapper.toDTO( repository.findById(id).orElse(null) );
            if ( departamentoBD != null ){
                departamentoBD.setNombre(departamento.getNombre());
                departamentoBD.setEstado(departamento.getEstado());
                return mapper.toDTO( repository.actualizar( mapper.toEntity( departamentoBD ) ) );
            }
            return null;
        }
    }

    @Override
    public Integer eliminarDepartamento(Integer id) {
        Departamento departamentoBD = repository.findById(id).orElse(null);

        if ( departamentoBD != null ) {
            //repository.deleteById(departamentoBD.getId());
            departamentoBD.setEstado(0);
            repository.actualizar(departamentoBD);
            return 1;
        }
        return 0;
    }
}

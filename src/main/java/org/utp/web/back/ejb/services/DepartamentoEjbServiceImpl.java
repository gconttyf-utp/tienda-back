package org.utp.web.back.ejb.services;

import java.util.List;

import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.transaction.Transactional;
import org.utp.web.back.ejb.entities.Departamento;
import org.utp.web.back.ejb.repositories.DepartamentoRepository;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class DepartamentoEjbServiceImpl implements DepartamentoEjbService {

    @Inject
    private DepartamentoRepository repository;

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
    public List<Departamento> listarDepartamentos(List<Integer> estados) {
        return repository.findByEstadoIn(estados);
    }

    @Override
    public Departamento encontrarDepartamento(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Departamento salvarDepartamento(Integer id, Departamento departamento) {
        if ( id == null || id == 0){
            return repository.insertar(departamento);
        } else {
            Departamento departamentoBD = repository.findById(id).orElse(null);
            if ( departamentoBD != null ){
                departamentoBD.setNombre(departamento.getNombre());
                departamentoBD.setEstado(departamento.getEstado());
                return repository.actualizar(departamentoBD);
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

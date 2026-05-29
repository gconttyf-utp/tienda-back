package org.utp.web.back.ejb.services;

import java.util.List;

import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import org.utp.web.back.ejb.entities.Ubigeo;
import org.utp.web.back.ejb.repositories.UbigeoRepository;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class UbigeoEjbServiceImpl implements UbigeoEjbService {

    @Inject
    private UbigeoRepository repository;

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Ubigeo> listarDepartamentos() {
        return repository.findAllDepartamentos();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Ubigeo> listarProvinciasDistritos(String codUbigeoPadre) {
        return repository.findAllProvinciasDistritos(codUbigeoPadre);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Ubigeo buscarUbigeo(String codUbigeo) {
        return repository.findByUbigeo(codUbigeo);
    }
}

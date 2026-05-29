package org.utp.web.back.apirest.services;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import org.utp.web.back.ejb.entities.Ubigeo;
import org.utp.web.back.ejb.services.UbigeoEjbService;

import java.util.List;

@RequestScoped
public class UbigeoServiceImpl implements UbigeoService{

    @Inject
    private UbigeoEjbService ubigeoServiceRemote;

    @Override
    public List<Ubigeo> listarDepartamentos() {
        return ubigeoServiceRemote.listarDepartamentos();
    }

    @Override
    public List<Ubigeo> listarProvinciasDistritos(String codigoPadre) {
        return ubigeoServiceRemote.listarProvinciasDistritos(codigoPadre);
    }

    @Override
    public Ubigeo buscarUbigeo(String codigo) {
        return ubigeoServiceRemote.buscarUbigeo(codigo);
    }
}

package org.utp.web.back.ejb.services;

import java.util.List;

import org.utp.web.back.ejb.entities.Ubigeo;

import jakarta.ejb.Remote;

@Remote
public interface UbigeoEjbService {

    List<Ubigeo> listarDepartamentos();
    List<Ubigeo> listarProvinciasDistritos(String codUbigeoPadre);
    Ubigeo buscarUbigeo(String codUbigeo);
    
}

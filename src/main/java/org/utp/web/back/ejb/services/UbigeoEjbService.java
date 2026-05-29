package org.utp.web.back.ejb.services;

import java.util.List;

import jakarta.ejb.Local;
import org.utp.web.back.ejb.entities.Ubigeo;

@Local
public interface UbigeoEjbService {

    List<Ubigeo> listarDepartamentos();
    List<Ubigeo> listarProvinciasDistritos(String codUbigeoPadre);
    Ubigeo buscarUbigeo(String codUbigeo);
    
}

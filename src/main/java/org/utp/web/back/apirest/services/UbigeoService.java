package org.utp.web.back.apirest.services;

import org.utp.web.back.ejb.entities.Ubigeo;

import java.util.List;

public interface UbigeoService {

    List<Ubigeo> listarDepartamentos();

    List<Ubigeo> listarProvinciasDistritos(String codigoPadre);

    Ubigeo buscarUbigeo(String codigo);

}

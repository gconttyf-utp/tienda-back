package org.utp.web.back.ejb.services;

import jakarta.ejb.Local;
import org.utp.web.back.ejb.entities.Almacen;

import java.util.List;

@Local
public interface AlmacenEjbService {

    List<Almacen> listado(Integer tienda);

    Almacen encontrarId(Integer id);

    Almacen save(Integer id, Almacen oDTO);

}

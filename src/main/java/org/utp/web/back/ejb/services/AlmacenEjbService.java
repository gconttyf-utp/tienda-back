package org.utp.web.back.ejb.services;

import jakarta.ejb.Remote;
import org.utp.web.back.ejb.entities.Almacen;

import java.util.List;

@Remote
public interface AlmacenEjbService {

    List<Almacen> listado(Integer tienda);

    Almacen encontrarId(Integer id);

    Almacen save(Integer id, Almacen oDTO);

}

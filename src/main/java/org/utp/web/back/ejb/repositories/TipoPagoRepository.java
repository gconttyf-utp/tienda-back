package org.utp.web.back.ejb.repositories;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;
import org.utp.web.back.ejb.entities.TipoPago;

@Repository
public interface TipoPagoRepository extends CrudRepository<TipoPago, Integer> {
}

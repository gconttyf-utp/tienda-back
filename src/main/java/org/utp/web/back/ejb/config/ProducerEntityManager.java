package org.utp.web.back.ejb.config;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RequestScoped
public class ProducerEntityManager {

    @Produces
    @PersistenceContext(unitName = "tiendaVegaJPA")
    private EntityManager em;

}

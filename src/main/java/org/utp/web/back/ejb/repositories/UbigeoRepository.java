package org.utp.web.back.ejb.repositories;

import java.util.List;

import org.utp.web.back.ejb.entities.Ubigeo;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

@RequestScoped
public class UbigeoRepository {

    @Inject
    private EntityManager em;

    public List<Ubigeo> findAllDepartamentos() {
        return em.createQuery("SELECT u FROM Ubigeo u WHERE u.codUbigeoPadre = '000000'", Ubigeo.class).getResultList();
    }

    public List<Ubigeo> findAllProvinciasDistritos(String codUbigeoPadre) {
        return em.createQuery("SELECT u FROM Ubigeo u WHERE u.codUbigeoPadre = '" + codUbigeoPadre + "'", Ubigeo.class)
                .getResultList();
    }

    public Ubigeo findByUbigeo(String codUbigeo) {
        try {
            // Ubigeo ubigeo = em.find(Ubigeo.class, codUbigeo);
            Ubigeo ubigeo = em.createQuery("SELECT u FROM Ubigeo u WHERE u.codUbigeo = :codUbigeo", Ubigeo.class)
                    .setParameter("codUbigeo", codUbigeo)
                    .getSingleResult();
            return ubigeo;
        } catch (NoResultException e) {
            return null;
        }
    }
}

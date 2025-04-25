package com.gherex.persistence;

import com.gherex.logic.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PersonaJpaController {

    public void create(Persona persona) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(persona);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void edit(Persona persona) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(persona);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void destroy(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Persona persona = em.find(Persona.class, id);
            if (persona != null) {
                em.remove(persona);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Persona findPersona(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        return em.find(Persona.class, id);
    }

    public List<Persona> findPersonaEntities() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Persona> query = em.createQuery("SELECT p FROM Persona p", Persona.class);
        return query.getResultList();
    }
}


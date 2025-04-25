package com.gherex.persistence;

import com.gherex.logic.Turno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class TurnoJpaController {

    public void create(Turno turno) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(turno);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void edit(Turno turno) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(turno);
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
            Turno turno = em.find(Turno.class, id);
            if (turno != null) {
                em.remove(turno);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Turno findTurno(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        return em.find(Turno.class, id);
    }

    public List<Turno> findTurnoEntities() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Turno> query = em.createQuery("SELECT t FROM Turno t", Turno.class);
        return query.getResultList();
    }
}
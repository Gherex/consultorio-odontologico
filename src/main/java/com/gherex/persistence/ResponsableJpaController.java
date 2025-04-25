package com.gherex.persistence;

import com.gherex.logic.Responsable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ResponsableJpaController {

    public void create(Responsable responsable) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(responsable);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void edit(Responsable responsable) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(responsable);
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
            Responsable responsable = em.find(Responsable.class, id);
            if (responsable != null) {
                em.remove(responsable);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Responsable findResponsable(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        return em.find(Responsable.class, id);
    }

    public List<Responsable> findResponsableEntities() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Responsable> query = em.createQuery("SELECT r FROM Responsable r", Responsable.class);
        return query.getResultList();
    }
}
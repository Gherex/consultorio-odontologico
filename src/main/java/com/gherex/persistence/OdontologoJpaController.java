package com.gherex.persistence;

import com.gherex.logic.Odontologo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class OdontologoJpaController {

    public void create(Odontologo odontologo) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(odontologo);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void edit(Odontologo odontologo) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(odontologo);
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
            Odontologo odontologo = em.find(Odontologo.class, id);
            if (odontologo != null) {
                em.remove(odontologo);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Odontologo findOdontologo(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        return em.find(Odontologo.class, id);
    }

    public List<Odontologo> findOdontologoEntities() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Odontologo> query = em.createQuery("SELECT o FROM Odontologo o", Odontologo.class);
        return query.getResultList();
    }
}
package com.gherex.persistence;

import com.gherex.logic.Secretario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class SecretarioJpaController {

    public void create(Secretario secretario) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(secretario);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void edit(Secretario secretario) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(secretario);
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
            Secretario secretario = em.find(Secretario.class, id);
            if (secretario != null) {
                em.remove(secretario);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Secretario findSecretario(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        return em.find(Secretario.class, id);
    }

    public List<Secretario> findSecretarioEntities() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Secretario> query = em.createQuery("SELECT s FROM Secretario s", Secretario.class);
        return query.getResultList();
    }
}

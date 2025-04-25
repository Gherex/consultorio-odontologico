package com.gherex.persistence;

import com.gherex.logic.Horario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class HorarioJpaController {

    public void create(Horario horario) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(horario);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void edit(Horario horario) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(horario);
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
            Horario horario = em.find(Horario.class, id);
            if (horario != null) {
                em.remove(horario);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Horario findHorario(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        return em.find(Horario.class, id);
    }

    public List<Horario> findHorarioEntities() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Horario> query = em.createQuery("SELECT h FROM Horario h", Horario.class);
        return query.getResultList();
    }
}

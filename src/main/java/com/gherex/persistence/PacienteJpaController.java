package com.gherex.persistence;

import com.gherex.logic.Paciente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PacienteJpaController {

    public void create(Paciente paciente) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(paciente);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void edit(Paciente paciente) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(paciente);
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
            Paciente paciente = em.find(Paciente.class, id);
            if (paciente != null) {
                em.remove(paciente);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Paciente findPaciente(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        return em.find(Paciente.class, id);
    }

    public List<Paciente> findPacienteEntities() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Paciente> query = em.createQuery("SELECT p FROM Paciente p", Paciente.class);
        return query.getResultList();
    }
}

package be.bstorm.repositories.impl;

import be.bstorm.entities.Mecanicien;
import be.bstorm.repositories.MecanicienRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class MecanicienRepositoryImpl implements MecanicienRepository {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("AirportDB");

    @Override
    public void add(Mecanicien mecano) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(mecano);
            em.getTransaction().commit();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public Mecanicien getByID(long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Mecanicien.class, id);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public List<Mecanicien> getAll() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Mecanicien> query = em.createQuery("SELECT m FROM Mecanicien m", Mecanicien.class);
            return query.getResultList();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public void update(Mecanicien mecano, long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Mecanicien mecanoFound = em.find(Mecanicien.class, id);
            if (mecanoFound != null) {
                mecanoFound.setNom(mecano.getNom());
                mecanoFound.setTelephone(mecano.getTelephone());
                mecanoFound.setAdresse(mecano.getAdresse());
                em.getTransaction().commit();
            }
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public void delete(long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Mecanicien mecanoFound = em.find(Mecanicien.class, id);
            if (mecanoFound != null) {
                em.remove(mecanoFound);
                em.getTransaction().commit();
            }
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
}

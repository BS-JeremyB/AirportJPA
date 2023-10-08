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
    private static final EntityManager em = emf.createEntityManager();

    @Override
    public void add(Mecanicien mecano) {

        em.getTransaction().begin();
        em.persist(mecano);
        em.getTransaction().commit();

    }

    @Override
    public Mecanicien getByID(long id) {

        return  em.find(Mecanicien.class, id);
    }

    @Override
    public List<Mecanicien> getAll() {
        TypedQuery<Mecanicien> query = em.createQuery("SELECT m FROM Mecanicien m", Mecanicien.class);
        return query.getResultList();
    }

    @Override
    public void update(Mecanicien mecano, long id) {

        em.getTransaction().begin();
        Mecanicien mecanoFound = em.find(Mecanicien.class, id);
        if (mecanoFound != null) {

            mecanoFound.setNom(mecano.getNom());
            mecanoFound.setTelephone(mecano.getTelephone());
            mecanoFound.setAdresse(mecano.getAdresse());
            em.getTransaction().commit();
        }

    }

    @Override
    public void delete(long id) {
        em.getTransaction().begin();
        Mecanicien mecanoFound = em.find(Mecanicien.class, id);
        if (mecanoFound != null) {

            em.remove(mecanoFound);
            em.getTransaction().commit();
        }
    }
}

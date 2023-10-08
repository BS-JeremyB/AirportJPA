package be.bstorm.repositories;

import be.bstorm.entities.Mecanicien;

import java.util.List;

public interface MecanicienRepository {
    void add (Mecanicien mecano);
    Mecanicien getByID(long id);
    List<Mecanicien> getAll();
    void update(Mecanicien mecano, long id);
    void delete(long id);
}

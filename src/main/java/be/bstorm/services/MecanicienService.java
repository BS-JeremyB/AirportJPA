package be.bstorm.services;

import be.bstorm.entities.Mecanicien;

import java.util.List;

public interface MecanicienService {

    void add (Mecanicien mecano);
    Mecanicien getByID(long id);
    List<Mecanicien> getAll();
    void update(Mecanicien mecano, long id);
    void delete(long id);
}

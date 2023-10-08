package be.bstorm.services.impl;

import be.bstorm.entities.Mecanicien;
import be.bstorm.repositories.MecanicienRepository;
import be.bstorm.repositories.impl.MecanicienRepositoryImpl;
import be.bstorm.services.MecanicienService;

import java.util.List;

public class MecanicienServiceImpl implements MecanicienService {

    private final MecanicienRepository mecanicienRepository;

    public MecanicienServiceImpl(){
       this.mecanicienRepository  = new MecanicienRepositoryImpl();
    }
    @Override
    public void add(Mecanicien mecano) {
        mecanicienRepository.add(mecano);

    }

    @Override
    public Mecanicien getByID(long id) {
        return mecanicienRepository.getByID(id);
    }

    @Override
    public List<Mecanicien> getAll() {
        return mecanicienRepository.getAll();
    }

    @Override
    public void update(Mecanicien mecano, long id) {
        mecanicienRepository.update(mecano,id);

    }

    @Override
    public void delete(long id) {
        mecanicienRepository.delete(id);

    }
}

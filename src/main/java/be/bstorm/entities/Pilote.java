package be.bstorm.entities;

import be.bstorm.entities.embedded.Adresse;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Pilote extends Membre{
    public Pilote(String nom, String telephone, Adresse adresse, String brevet) {
        super(nom, telephone, adresse);
        this.brevet = brevet;
    }

    private String brevet;


    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<TypeAvion> typeAvions;

    public List<TypeAvion> getTypeAvions() {
        return List.copyOf(typeAvions);
    }

    public void addTypeAvion(TypeAvion typeAvion){
        this.typeAvions.add(typeAvion);
    }

    public void removeTypeAvion(TypeAvion typeAvion){
        this.typeAvions.remove(typeAvion);
    }


}

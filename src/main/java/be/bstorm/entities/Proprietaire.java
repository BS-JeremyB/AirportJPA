package be.bstorm.entities;

import be.bstorm.entities.embedded.Adresse;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;


import java.util.List;

@Entity
public class Proprietaire extends Membre{
    public Proprietaire(String nom, String telephone, Adresse adresse) {
        super(nom, telephone, adresse);
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Avion> avionsPossedes;

    public List<Avion> getAvions() {
        return List.copyOf(avionsPossedes);
    }

    public void addAvion(Avion avionsPossede){
        this.avionsPossedes.add(avionsPossede);
    }

    public void removeAvion(Avion avionsPossede){
        this.avionsPossedes.remove(avionsPossede);
    }

}

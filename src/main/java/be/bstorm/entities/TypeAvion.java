package be.bstorm.entities;

import jakarta.persistence.*;


import java.util.List;

@Entity
public class TypeAvion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String constructeur;
    private int puissance;
    private int nbrPlace;

    @OneToMany(mappedBy = "type")
    private List<Avion> avions;

    public List<Avion> getAvions() {
        return List.copyOf(avions);
    }

    public void addAvion(Avion avion){
        this.avions.add(avion);
    }

    public void removeAvion(Avion avion){
        this.avions.remove(avion);
    }



}

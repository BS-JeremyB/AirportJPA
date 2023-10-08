package be.bstorm.entities;


import be.bstorm.entities.embedded.Adresse;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Mecanicien extends Membre {

    public Mecanicien(String nom, String telephone, Adresse adresse) {
        super(nom, telephone, adresse);
    }

    public Mecanicien(){};

    @OrderBy("numero")
    @OneToMany(mappedBy = "verificateur")
    private List<Intervention> interventionsVerificateur = new ArrayList<>();

    @OrderBy("numero")
    @OneToMany(mappedBy = "reparateur")
    private List<Intervention> interventionsReparateur = new ArrayList<>();

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

    public List<Intervention> getInterventionsRep() {
        return List.copyOf(interventionsReparateur);
    }

    public void addInterventionRep(Intervention intervention){
        this.interventionsReparateur.add(intervention);
    }

    public void removeInterventionRep(Intervention intervention){
        this.interventionsReparateur.remove(intervention);
    }

    public List<Intervention> getInterventionsVer() {
        return List.copyOf(interventionsVerificateur);
    }

    public void addInterventionVer(Intervention intervention){
        this.interventionsVerificateur.add(intervention);
    }

    public void removeInterventionVer(Intervention intervention){
        this.interventionsVerificateur.remove(intervention);
    }
}

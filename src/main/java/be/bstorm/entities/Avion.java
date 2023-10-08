package be.bstorm.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Avion {

    @Id
    private String immatriculation;

    @ManyToOne
    private TypeAvion type;
    @OneToMany(mappedBy = "avion")
    private List<Intervention> interventions;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Proprietaire> proprietaires;

    public List<Intervention> getInterventions() {
        return List.copyOf(interventions);
    }

    public void addIntervention(Intervention intervention){
        this.interventions.add(intervention);
    }

    public void removeIntervention(Intervention intervention){
        this.interventions.remove(intervention);
    }

    public List<Proprietaire> getpProprietaires() {
        return List.copyOf(proprietaires);
    }

    public void addProprietaire(Proprietaire proprietaire){
        this.proprietaires.add(proprietaire);
    }

    public void removeProprietaire(Proprietaire proprietaire){
        this.proprietaires.remove(proprietaire);
    }
}

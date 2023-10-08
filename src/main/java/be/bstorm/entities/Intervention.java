package be.bstorm.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Intervention {

    @Id
    private long numero;
    private String objet;
    @Temporal(TemporalType.DATE)
    private LocalDate date;
    private int duree;

    @ManyToOne
    private Mecanicien verificateur;
    @ManyToOne
    private Mecanicien reparateur;
    @ManyToOne
    private Avion avion;

}

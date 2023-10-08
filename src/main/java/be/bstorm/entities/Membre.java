package be.bstorm.entities;

import be.bstorm.entities.embedded.Adresse;
import jakarta.persistence.*;
import lombok.*;

@MappedSuperclass
@Getter @Setter @ToString @EqualsAndHashCode @NoArgsConstructor
public abstract class Membre {

    public Membre(String nom, String telephone, Adresse adresse) {
        this.nom = nom;
        this.telephone = telephone;
        this.adresse = adresse;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nom;
    private String telephone;

    @Embedded
    private Adresse adresse;
}
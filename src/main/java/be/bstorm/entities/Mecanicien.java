package be.bstorm.entities;


import be.bstorm.entities.embedded.Adresse;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString @EqualsAndHashCode
public class Mecanicien {

    public Mecanicien(String nom, String telephone, Adresse adresse) {
        this.nom = nom;
        this.telephone = telephone;
        this.adresse = adresse;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String telephone;

    @Embedded
    private Adresse adresse;

}

package be.bstorm.entities.embedded;

import jakarta.persistence.Embeddable;
import lombok.*;


@Embeddable
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor @ToString @EqualsAndHashCode
public class Adresse {

    private String rue;
    private int numero;
    private String box;
    private int cp;
    private String Ville;

    public Adresse(String rueTfTic, int i, Object o, int i1, String gosselies) {
    }
}

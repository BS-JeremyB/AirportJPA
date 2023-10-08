package be.bstorm;

import be.bstorm.entities.Mecanicien;
import be.bstorm.entities.embedded.Adresse;
import be.bstorm.repositories.impl.MecanicienRepositoryImpl;

import java.util.List;

public class MainAirport {
    public static void main(String[] args) {

        MecanicienRepositoryImpl mecano = new MecanicienRepositoryImpl();


        //Ajout d'un nouveau mécanicien
        mecano.add(new Mecanicien("Bazin","+32 471 55 55 55",
                new Adresse("Rue TF TIC",0, null,6041,"Gosselies")));

        mecano.add(new Mecanicien("Doe","+32 471 33 33 33",
                new Adresse("Rue de la Gare",10, null,6000,"Charleroi")));


        //recuperer tous les mécanicien

        List<Mecanicien> mecaniciens = mecano.getAll();
        mecaniciens.forEach((m)-> System.out.println(m.toString()));


        //Modifier un mécanicien dans la table

        mecano.update(new Mecanicien("Bazin","+32 471 66 66 66",
                new Adresse("Rue TF TIC",0, null,6041,"Gosselies")), 1);


        //recuperer un mécanicien dans la table

        System.out.println(mecano.getByID(1).toString());


        //Suprimer un mécanicien dans la table via son ID

        mecano.delete(2);

    }
}

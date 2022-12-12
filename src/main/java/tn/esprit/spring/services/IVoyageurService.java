package tn.esprit.spring.services;

import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Voyage;
import tn.esprit.spring.entities.Voyageur;

import java.util.List;


public interface IVoyageurService {
    Voyage ajouterVoyageur(Voyageur Voyageur);
    //Modifier le voyageur
    void modifierVoyageur(Voyageur voyageur);
    List<Voyageur> recupererAll();
    Voyageur recupererVoyageParId(long idVoyageur);
    void supprimerVoyageur(Voyageur v);
}

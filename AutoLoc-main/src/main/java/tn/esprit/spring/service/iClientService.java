package tn.esprit.spring.service;

import tn.esprit.spring.domain.CategorieVehicule;
import tn.esprit.spring.domain.Client;

import java.util.List;

public interface iClientService {
    Client creer(Client client);
    Client obtenirParId(Long id);
    List<Client> listerTous();
    Client mettreAJour(Client client);
    void supprimer(Long id);
    Client ajouterReservationClient(Client c);
    Client ajouterReservationClient2(Client c);
    List<Client> recupererParPrenomNomEtCategorieVehicule(String prenom, String nom, CategorieVehicule categorieVehicule);
}


package tn.esprit.spring.service;

import tn.esprit.spring.domain.Vehicule;

import java.util.List;

public interface iVehiculeService {
    Vehicule creer(Vehicule vehicule);
    Vehicule obtenirParId(Long id);
    List<Vehicule> listerTous();
    Vehicule mettreAJour(Vehicule vehicule);
    void supprimer(Long id);
    Vehicule affecterEquipementVehicule(long idv, long ideq);
}


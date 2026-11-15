package tn.esprit.spring.service;

import tn.esprit.spring.domain.Maintenance;
import tn.esprit.spring.domain.Vehicule;

import java.util.List;

public interface iMaintenanceService {
    Maintenance creer(Maintenance maintenance);
    Maintenance obtenirParId(Long id);
    List<Maintenance> listerTous();
    Maintenance mettreAJour(Maintenance maintenance);
    void supprimer(Long id);
    Vehicule affecterMaintenanceVehicule(long idm, long idv);
}


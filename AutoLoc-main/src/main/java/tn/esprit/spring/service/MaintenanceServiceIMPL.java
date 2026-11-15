package tn.esprit.spring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.domain.Maintenance;
import tn.esprit.spring.domain.Vehicule;
import tn.esprit.spring.repository.MaintenanceRepository;
import tn.esprit.spring.repository.VehiculeRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class MaintenanceServiceIMPL implements iMaintenanceService {

    MaintenanceRepository maintenanceRepo;
    VehiculeRepository vehiculeRepo;

    @Override
    public Maintenance creer(Maintenance maintenance) {
        return maintenanceRepo.save(maintenance);
    }

    @Override
    public Maintenance obtenirParId(Long id) {
        return maintenanceRepo.findById(id).orElse(null);
    }

    @Override
    public List<Maintenance> listerTous() {
        return (List<Maintenance>) maintenanceRepo.findAll();
    }

    @Override
    public Maintenance mettreAJour(Maintenance maintenance) {
        return maintenanceRepo.save(maintenance);
    }

    @Override
    public void supprimer(Long id) {
        maintenanceRepo.deleteById(id);
    }

    @Override
    public Vehicule affecterMaintenanceVehicule(long idm, long idv) {
        // donnees
        Vehicule vehicule = vehiculeRepo.findById(idv).orElse(null);
        Maintenance maintenance = maintenanceRepo.findById(idm).orElse(null);
        assert vehicule != null;
        if (vehicule.getMaintenances() == null) {
            vehicule.setMaintenances(new ArrayList<>());
        }
        vehicule.getMaintenances().add(maintenance);
        // save
        Vehicule save = vehiculeRepo.save(vehicule);
        return save;
    }
}


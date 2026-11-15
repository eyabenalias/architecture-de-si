package tn.esprit.spring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.domain.Equipement;
import tn.esprit.spring.domain.Vehicule;
import tn.esprit.spring.repository.EquipementRepository;
import tn.esprit.spring.repository.VehiculeRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class VehiculeServiceIMPL implements iVehiculeService {

    VehiculeRepository vehiculeRepo;
    EquipementRepository equipementRepo;

    @Override
    public Vehicule creer(Vehicule vehicule) {
        return vehiculeRepo.save(vehicule);
    }

    @Override
    public Vehicule obtenirParId(Long id) {
        return vehiculeRepo.findById(id).orElse(null);
    }

    @Override
    public List<Vehicule> listerTous() {
        return (List<Vehicule>) vehiculeRepo.findAll();
    }

    @Override
    public Vehicule mettreAJour(Vehicule vehicule) {
        return vehiculeRepo.save(vehicule);
    }

    @Override
    public void supprimer(Long id) {
        vehiculeRepo.deleteById(id);
    }

    @Override
    public Vehicule affecterEquipementVehicule(long idv, long ideq) {
        // donnees
        Vehicule vehicule = vehiculeRepo.findById(idv).orElse(null);
        Equipement equipement = equipementRepo.findById(ideq).orElse(null);
        assert vehicule != null;
        if (vehicule.getEquipements() == null) {
            vehicule.setEquipements(new ArrayList<>());
        }
        vehicule.getEquipements().add(equipement);
        // save
        Vehicule save = vehiculeRepo.save(vehicule);
        return save;
    }
}


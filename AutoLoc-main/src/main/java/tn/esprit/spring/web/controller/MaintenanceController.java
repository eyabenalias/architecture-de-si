package tn.esprit.spring.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.domain.Maintenance;
import tn.esprit.spring.domain.Vehicule;
import tn.esprit.spring.service.iMaintenanceService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/MaintenanceController")
public class MaintenanceController {

    iMaintenanceService maintenanceService;

    @PostMapping("/create")
    public Maintenance creer(@RequestBody Maintenance maintenance) {
        return maintenanceService.creer(maintenance);
    }

    @GetMapping("/getmaintenance/{id}")
    public Maintenance obtenirParId(@PathVariable long id) {
        return maintenanceService.obtenirParId(id);
    }

    @GetMapping("/getAll")
    public List<Maintenance> listerTous() {
        return maintenanceService.listerTous();
    }

    @PutMapping("/update")
    public Maintenance mettreAJour(@RequestBody Maintenance maintenance) {
        return maintenanceService.mettreAJour(maintenance);
    }

    @DeleteMapping("/delete/{id}")
    public void supprimer(@PathVariable Long id) {
        maintenanceService.supprimer(id);
    }

    @PutMapping("/affecterMaintenanceVehicule/{idm}/{idv}")
    public Vehicule affecterMaintenanceVehicule(@PathVariable long idm, @PathVariable long idv) {
        return maintenanceService.affecterMaintenanceVehicule(idm, idv);
    }
}


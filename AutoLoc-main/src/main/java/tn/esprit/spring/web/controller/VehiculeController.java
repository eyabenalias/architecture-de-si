package tn.esprit.spring.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.domain.Vehicule;
import tn.esprit.spring.service.iVehiculeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/VehiculeController")
public class VehiculeController {

    iVehiculeService vehiculeService;

    @PostMapping("/create")
    public Vehicule creer(@RequestBody Vehicule vehicule) {
        return vehiculeService.creer(vehicule);
    }

    @GetMapping("/getvehicule/{id}")
    public Vehicule obtenirParId(@PathVariable long id) {
        return vehiculeService.obtenirParId(id);
    }

    @GetMapping("/getAll")
    public List<Vehicule> listerTous() {
        return vehiculeService.listerTous();
    }

    @PutMapping("/update")
    public Vehicule mettreAJour(@RequestBody Vehicule vehicule) {
        return vehiculeService.mettreAJour(vehicule);
    }

    @DeleteMapping("/delete/{id}")
    public void supprimer(@PathVariable Long id) {
        vehiculeService.supprimer(id);
    }

    @PutMapping("/affecterEquipementVehicule/{idv}/{ideq}")
    public Vehicule affecterEquipementVehicule(@PathVariable long idv, @PathVariable long ideq) {
        return vehiculeService.affecterEquipementVehicule(idv, ideq);
    }
}


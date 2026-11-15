package tn.esprit.spring.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.domain.CategorieVehicule;
import tn.esprit.spring.domain.Client;
import tn.esprit.spring.service.iClientService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/ClientController")
public class ClientController {

    iClientService clientService;

    @PostMapping("/create")
    public Client creer(@RequestBody Client client) {
        return clientService.creer(client);
    }

    @GetMapping("/getclient/{id}")
    public Client obtenirParId(@PathVariable long id) {
        return clientService.obtenirParId(id);
    }

    @GetMapping("/getAll")
    public List<Client> listerTous() {
        return clientService.listerTous();
    }

    @PutMapping("/update")
    public Client mettreAJour(@RequestBody Client client) {
        return clientService.mettreAJour(client);
    }

    @DeleteMapping("/delete/{id}")
    public void supprimer(@PathVariable Long id) {
        clientService.supprimer(id);
    }

    @PostMapping("/ajouterReservationClient")

    public Client ajouterReservationClient(@RequestBody Client c) {
        return clientService.ajouterReservationClient(c);
    }
@PostMapping("/ajouterReservationClient2")
    public Client ajouterReservationClient2(@RequestBody Client c) {
        return clientService.ajouterReservationClient2(c);
    }
@PostMapping("/recupererParPrenomNomEtCategorieVehicule")

    public List<Client> recupererParPrenomNomEtCategorieVehicule(String prenom, String nom, CategorieVehicule categorieVehicule) {
        return clientService.recupererParPrenomNomEtCategorieVehicule(prenom, nom, categorieVehicule);
    }
}



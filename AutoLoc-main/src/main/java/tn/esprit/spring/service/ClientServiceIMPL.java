package tn.esprit.spring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.domain.CategorieVehicule;
import tn.esprit.spring.domain.Client;
import tn.esprit.spring.domain.Reservation;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.ReservationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceIMPL implements iClientService {

    ClientRepository clientRepo;
    ReservationRepository reservationRepo;

    @Override
    public Client creer(Client client) {
        return clientRepo.save(client);
    }

    @Override
    public Client obtenirParId(Long id) {
        return clientRepo.findById(id).orElse(null);
    }

    @Override
    public List<Client> listerTous() {
        return (List<Client>) clientRepo.findAll();
    }

    @Override
    public Client mettreAJour(Client client) {
        return clientRepo.save(client);
    }

    @Override
    public void supprimer(Long id) {
        clientRepo.deleteById(id);
    }

    @Override
    public Client ajouterReservationClient(Client c) {
        Client client = clientRepo.save(c);
        if (c.getReservations() != null) {
            for (Reservation res : c.getReservations()) {
                res.setClient(client);
                reservationRepo.save(res);
            }
        }
        return client;
    }

    @Override
    public Client ajouterReservationClient2(Client c){
        //donnees
        clientRepo.save(c);
        //AFFECTATION
        for(Reservation r : c.getReservations()){
            r.setClient(c);
            //sauvegarder les modiffications dans la base de données
            reservationRepo.save(r);
        }
        return c;
    }

    @Override
    public List<Client> recupererParPrenomNomEtCategorieVehicule(String prenom, String nom, CategorieVehicule categorieVehicule) {
        return clientRepo.findByPrenomAndNomAndCategorieVehicule(prenom, nom, categorieVehicule);
    }
}


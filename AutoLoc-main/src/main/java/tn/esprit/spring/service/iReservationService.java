package tn.esprit.spring.service;

import tn.esprit.spring.domain.Reservation;

import java.util.List;

public interface iReservationService {
    Reservation creer(Reservation reservation);
    Reservation obtenirParId(Long id);
    List<Reservation> listerTous();
    Reservation mettreAJour(Reservation reservation);
    void supprimer(Long id);
    Reservation ajouterReservationContrat(Reservation r);
    Reservation ajouterReservationContrat2(Reservation r);
    void verifierReservationsExpirees();
    void terminerReservationsExpireesEtLibererVehicules();
}

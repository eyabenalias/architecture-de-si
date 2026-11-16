package tn.esprit.spring.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.spring.domain.Contrat;
import tn.esprit.spring.domain.Reservation;
import tn.esprit.spring.domain.StatutReservation;
import tn.esprit.spring.domain.StatutVehicule;
import tn.esprit.spring.domain.Vehicule;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.ReservationRepository;
import tn.esprit.spring.repository.VehiculeRepository;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class ReservationServiceIMPL implements iReservationService {

    ReservationRepository reservationRepo;
    ContratRepository contratRepo;
    VehiculeRepository vehiculeRepo;

    @Override
    public Reservation ajouterReservationContrat2(Reservation r) {
        return reservationRepo.save(r);
    }

    @Override
    public Reservation creer(Reservation reservation) {
        return reservationRepo.save(reservation);
    }

    @Override
    public Reservation obtenirParId(Long id) {
        return reservationRepo.findById(id).orElse(null);
    }

    @Override
    public List<Reservation> listerTous() {
        return (List<Reservation>) reservationRepo.findAll();
    }

    @Override
    public Reservation mettreAJour(Reservation reservation) {
        return reservationRepo.save(reservation);
    }

    @Override
    public void supprimer(Long id) {
        reservationRepo.deleteById(id);
    }

    @Override
    public Reservation ajouterReservationContrat(Reservation r) {
        if (r.getContrat() != null) {
            Contrat savedContrat = contratRepo.save(r.getContrat());
            r.setContrat(savedContrat);
        }
        return reservationRepo.save(r);
    }

    @Override
    public void verifierReservationsExpirees() {
        terminerReservationsExpireesEtLibererVehicules();
    }

    // S'exécute chaque jour à minuit (00:00:00)
    @Override
    @Scheduled(cron = "0 0 0 * * ?")
    public void terminerReservationsExpireesEtLibererVehicules() {
        log.info("Exécution du Scheduler : vérification des réservations expirées et libération des véhicules...");

        // 1. Récupérer toutes les réservations expirées ayant le statut CONFIRMEE et dateFin avant aujourd'hui
        List<Reservation> reservationsExpirees = reservationRepo.findByStatutAndDateFinBefore(
                StatutReservation.CONFIRMEE,
                LocalDate.now()
        );

        // 2. Mettre à jour le statut des réservations expirées à TERMINEE
        for (Reservation reservation : reservationsExpirees) {
            reservation.setStatut(StatutReservation.TERMINEE);
            reservationRepo.save(reservation);
            log.info("Réservation ID {} marquée comme TERMINEE.", reservation.getIdReservation());
        }

        // 3. Libérer les véhicules concernés à condition qu'ils ne possèdent aucune autre réservation active
        for (Reservation reservation : reservationsExpirees) {
            Vehicule vehicule = reservation.getVehicule();
            if (vehicule != null) {
                // Vérifier s'il existe une autre réservation active (CONFIRMEE) pour ce véhicule
                boolean aAutreReservationActive = reservationRepo.existsByVehiculeAndStatut(
                        vehicule,
                        StatutReservation.CONFIRMEE
                );

                if (!aAutreReservationActive) {
                    vehicule.setStatut(StatutVehicule.DISPONIBLE);
                    vehiculeRepo.save(vehicule);
                    log.info("Véhicule ID {} ({}) libéré -> statut DISPONIBLE.",
                            vehicule.getIdVehicule(), vehicule.getImmatriculation());
                } else {
                    log.info("Véhicule ID {} a encore d'autres réservations actives -> statut non modifié.",
                            vehicule.getIdVehicule());
                }
            }
        }

        log.info("Fin du Scheduler : {} réservation(s) expirée(s) traitée(s).", reservationsExpirees.size());
    }
}

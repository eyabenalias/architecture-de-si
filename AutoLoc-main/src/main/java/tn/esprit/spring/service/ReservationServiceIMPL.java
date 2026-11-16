package tn.esprit.spring.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.spring.domain.Contrat;
import tn.esprit.spring.domain.Reservation;
import tn.esprit.spring.domain.StatutReservation;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.ReservationRepository;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class ReservationServiceIMPL implements iReservationService {

    ReservationRepository reservationRepo;
    ContratRepository contratRepo;

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

    // S'exécute chaque jour à minuit (00:00:00)
    @Override
    @Scheduled(cron = "0 0 0 * * ?")
    public void verifierReservationsExpirees() {
        log.info("Vérification des réservations expirées...");
        List<Reservation> reservationsExpirees = reservationRepo.findByStatutAndDateFinBefore(
                StatutReservation.CONFIRMEE,
                LocalDate.now()
        );

        for (Reservation reservation : reservationsExpirees) {
            reservation.setStatut(StatutReservation.TERMINEE);
            reservationRepo.save(reservation);
            log.info("Réservation ID {} expirée -> Statut mis à jour à TERMINEE", reservation.getIdReservation());
        }

        log.info("Nombre de réservations mises à jour : {}", reservationsExpirees.size());
    }
}

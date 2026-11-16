package tn.esprit.spring.scheduler;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tn.esprit.spring.domain.Reservation;
import tn.esprit.spring.domain.StatutReservation;
import tn.esprit.spring.repository.ReservationRepository;

import java.time.LocalDate;
import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class ReservationScheduler {

    ReservationRepository reservationRepo;

    // S'exécute chaque jour à minuit : seconde=0, minute=0, heure=0, tous les jours du mois, tous les mois
    @Scheduled(cron = "0 0 0 * * ?")
    public void verifierReservationsExpirees() {
        log.info("Exécution du Scheduler : vérification des réservations expirées à minuit...");

        List<Reservation> reservationsExpirees = reservationRepo.findByStatutAndDateFinBefore(
                StatutReservation.CONFIRMEE,
                LocalDate.now()
        );

        for (Reservation reservation : reservationsExpirees) {
            reservation.setStatut(StatutReservation.TERMINEE);
            reservationRepo.save(reservation);
            log.info("Réservation ID {} expirée (dateFin: {}) -> Statut mis à jour à TERMINEE",
                    reservation.getIdReservation(), reservation.getDateFin());
        }

        log.info("Nombre de réservations mises à jour : {}", reservationsExpirees.size());
    }
}

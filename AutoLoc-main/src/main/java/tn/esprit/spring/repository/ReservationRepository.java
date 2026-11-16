package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.domain.Reservation;
import tn.esprit.spring.domain.StatutReservation;
import tn.esprit.spring.domain.Vehicule;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    List<Reservation> findByStatutAndDateFinBefore(StatutReservation statut, LocalDate date);
    boolean existsByVehiculeAndStatut(Vehicule vehicule, StatutReservation statut);
}

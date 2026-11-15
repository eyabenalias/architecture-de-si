package tn.esprit.spring.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.domain.Reservation;
import tn.esprit.spring.service.iReservationService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/ReservationController")
public class ReservationController {

    iReservationService reservationService;

    @PostMapping("/create")
    public Reservation creer(@RequestBody Reservation reservation) {
        return reservationService.creer(reservation);
    }

    @GetMapping("/getreservation/{id}")
    public Reservation obtenirParId(@PathVariable long id) {
        return reservationService.obtenirParId(id);
    }

    @GetMapping("/getAll")
    public List<Reservation> listerTous() {
        return reservationService.listerTous();
    }

    @PutMapping("/update")
    public Reservation mettreAJour(@RequestBody Reservation reservation) {
        return reservationService.mettreAJour(reservation);
    }

    @DeleteMapping("/delete/{id}")
    public void supprimer(@PathVariable Long id) {
        reservationService.supprimer(id);
    }

    @PostMapping("/ajouterReservationContrat")
    public Reservation ajouterReservationContrat(@RequestBody Reservation r) {
        return reservationService.ajouterReservationContrat(r);
    }
@PostMapping("/ajouterReservationContrat2")
    public Reservation ajouterReservationContrat2( @RequestBody Reservation r) {
        return reservationService.ajouterReservationContrat2(r);
    }
}


package tn.esprit.spring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idContrat;

    LocalDate dateSignature;

    BigDecimal montantTotal;

    boolean valide;
@JsonIgnore
    @OneToOne(mappedBy = "contrat")
    Reservation reservation;
@JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contrat")
    List<Paiement> paiements;
}

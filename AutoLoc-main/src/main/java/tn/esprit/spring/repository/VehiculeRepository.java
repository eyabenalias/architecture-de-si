package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.domain.Agence;
import tn.esprit.spring.domain.StatutVehicule;
import tn.esprit.spring.domain.Vehicule;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {

    // 1. Rechercher les véhicules d'une marque
    List<Vehicule> findByMarque(String marque);

    // 2. Rechercher les véhicules dont la marque contient un mot
    List<Vehicule> findByMarqueContaining(String mot);

    // 3. Rechercher les véhicules dont la marque commence par une valeur
    List<Vehicule> findByMarqueStartingWith(String valeur);

    // 4. Rechercher les véhicules dont la marque se termine par une valeur
    List<Vehicule> findByMarqueEndingWith(String valeur);

    // 5. Rechercher les véhicules par marque sans tenir compte de la casse
    List<Vehicule> findByMarqueIgnoreCase(String marque);

    // 6. Rechercher les véhicules par modèle
    List<Vehicule> findByModele(String modele);

    // 7. Vérifier si un véhicule existe avec une immatriculation donnée
    boolean existsByImmatriculation(String immatriculation);

    // 8. Compter les véhicules d'une marque
    long countByMarque(String marque);

    // 9. Véhicules dont le tarif est supérieur à une valeur
    List<Vehicule> findByTarifJournalierGreaterThan(BigDecimal tarif);

    // 10. Véhicules dont le tarif est inférieur à une valeur
    List<Vehicule> findByTarifJournalierLessThan(BigDecimal tarif);

    // 11. Véhicules dont le tarif est supérieur ou égal à une valeur
    List<Vehicule> findByTarifJournalierGreaterThanEqual(BigDecimal tarif);

    // 12. Véhicules dont le tarif est compris entre deux valeurs
    List<Vehicule> findByTarifJournalierBetween(BigDecimal min, BigDecimal max);

    // 13. Véhicules triés par tarif croissant
    List<Vehicule> findByOrderByTarifJournalierAsc();

    // 14. Véhicules triés par tarif décroissant
    List<Vehicule> findByOrderByTarifJournalierDesc();

    // 15. Véhicules d'une marque triés par tarif croissant
    List<Vehicule> findByMarqueOrderByTarifJournalierAsc(String marque);

    // 16. Véhicules d'une marque dont le tarif dépasse une valeur
    List<Vehicule> findByMarqueAndTarifJournalierGreaterThan(String marque, BigDecimal tarif);

    // 17. Véhicules d'une marque OU d'un modèle
    List<Vehicule> findByMarqueOrModele(String marque, String modele);

    // 18. Véhicules dont la marque figure dans une liste
    List<Vehicule> findByMarqueIn(List<String> marques);

    // 19. Véhicules dont la marque ne figure pas dans une liste
    List<Vehicule> findByMarqueNotIn(List<String> marques);

    // 20. Véhicules par le statut
    List<Vehicule> findByStatut(StatutVehicule statut);

    // 21. Véhicules DISPONIBLES triés par tarif croissant
    List<Vehicule> findByStatutOrderByTarifJournalierAsc(StatutVehicule statut);

    // 22. Véhicules appartenant à une agence
    List<Vehicule> findByAgence(Agence agence);
    List<Vehicule> findByAgenceIdAgence(Long idAgence);

    // 23. Véhicules appartenant à une agence d'une ville donnée
    List<Vehicule> findByAgenceVille(String ville);

    // 24. Véhicules d'une agence dont le nom contient une valeur
    List<Vehicule> findByAgenceNomContaining(String nom);

    // 25. Véhicules d'une agence et d'une marque données
    List<Vehicule> findByAgenceAndMarque(Agence agence, String marque);
    List<Vehicule> findByAgenceIdAgenceAndMarque(Long idAgence, String marque);

    // 26. Véhicules sans agence
    List<Vehicule> findByAgenceIsNull();

    // 27. Véhicules affectés à une agence
    List<Vehicule> findByAgenceIsNotNull();

    // 28. Compter les véhicules d'une agence
    long countByAgence(Agence agence);
    long countByAgenceIdAgence(Long idAgence);

    // 29. Vérifier si une agence possède des véhicules
    boolean existsByAgence(Agence agence);
    boolean existsByAgenceIdAgence(Long idAgence);
}

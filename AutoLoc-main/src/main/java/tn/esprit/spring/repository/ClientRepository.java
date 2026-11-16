package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.domain.CategorieVehicule;
import tn.esprit.spring.domain.Client;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    List<Client> findByPrenomAndNomAndReservations_Vehicule_Categorie(String prenom, String nom, CategorieVehicule categorieVehicule);
}
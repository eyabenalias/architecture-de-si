package tn.esprit.spring.repository;


import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.domain.Agence;

public interface AgenceRepository extends CrudRepository<Agence,Long> {
}

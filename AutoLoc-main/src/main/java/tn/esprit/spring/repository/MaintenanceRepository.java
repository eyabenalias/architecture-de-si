package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.domain.Maintenance;

@Repository
public interface MaintenanceRepository extends CrudRepository<Maintenance, Long> {
}


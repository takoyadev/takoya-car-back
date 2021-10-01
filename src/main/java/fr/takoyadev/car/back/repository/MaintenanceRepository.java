package fr.takoyadev.car.back.repository;

import fr.takoyadev.car.back.entity.Maintenance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceRepository extends CrudRepository<Maintenance, Long> {
}

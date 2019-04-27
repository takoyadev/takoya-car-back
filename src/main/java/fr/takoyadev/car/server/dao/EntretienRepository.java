package fr.takoyadev.car.server.dao;

import fr.takoyadev.car.server.entity.Entretien;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EntretienRepository extends CrudRepository<Entretien, Long> {
    List<Entretien> findByCarOwnerId(Long id);
    List<Entretien> findByCarId(Long id);
}

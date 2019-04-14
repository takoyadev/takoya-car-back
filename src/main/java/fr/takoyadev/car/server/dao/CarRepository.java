package fr.takoyadev.car.server.dao;


import fr.takoyadev.car.server.entity.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends CrudRepository<Car, Long> {

    Optional<Car> findById(Long id);
    List<Car> findAll();
}

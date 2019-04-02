package fr.takoyadev.car.server.dao;


import fr.takoyadev.car.server.entity.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {

    List<Car> findAll();
}

package fr.takoyadev.car.back.repository;

import fr.takoyadev.car.back.entity.Car;
import fr.takoyadev.car.back.entity.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {
}

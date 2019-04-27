package fr.takoyadev.car.server.dao;

import fr.takoyadev.car.server.entity.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}

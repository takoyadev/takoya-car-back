package fr.takoyadev.car.server.dao;


import fr.takoyadev.car.server.entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {

}

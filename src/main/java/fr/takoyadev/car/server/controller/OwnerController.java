package fr.takoyadev.car.server.controller;

import fr.takoyadev.car.server.dao.OwnerRepository;
import fr.takoyadev.car.server.entity.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class OwnerController {

    @Autowired
    private OwnerRepository ownerRepository;

    @RequestMapping("/owners")
    public Iterable<Owner> findAllCars() {
        return this.ownerRepository.findAll();
    }

    @RequestMapping("/owner/{id}")
    public Optional<Owner> findCar(@PathVariable Long id) {
        return this.ownerRepository.findById(id);
    }

    @RequestMapping(value = "/owner/add", method = RequestMethod.POST)
    public void saveCar(@RequestBody Owner owner) {
        this.ownerRepository.save(owner);
    }
}

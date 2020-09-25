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

    @GetMapping("/owners")
    public Iterable<Owner> findAllCars() {
        return this.ownerRepository.findAll();
    }

    @GetMapping("/owner/{id}")
    public Optional<Owner> findCar(@PathVariable Long id) {
        return this.ownerRepository.findById(id);
    }

    @PostMapping(value = "/owner/add")
    public void saveCar(@RequestBody Owner owner) {
        this.ownerRepository.save(owner);
    }
}

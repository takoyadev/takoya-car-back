package fr.takoyadev.car.server.controller;

import fr.takoyadev.car.server.dao.OwnerRepository;
import fr.takoyadev.car.server.entity.Owner;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(value = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/owner")
public class OwnerController {

    @NonNull
    private OwnerRepository ownerRepository;

    @GetMapping()
    public Iterable<Owner> findAllCars() {
        return this.ownerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Owner> findCar(@PathVariable Long id) {
        return this.ownerRepository.findById(id);
    }

    @PostMapping()
    public void saveCar(@RequestBody Owner owner) {
        this.ownerRepository.save(owner);
    }

}

package fr.takoyadev.car.server.controller;

import fr.takoyadev.car.server.dao.AddressRepository;
import fr.takoyadev.car.server.entity.Address;
import fr.takoyadev.car.server.entity.Entretien;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(value = "*")
@RestController
@RequiredArgsConstructor
public class AddressController {

    @NonNull
    private AddressRepository addressRepository;

    @GetMapping("/address")
    public Iterable<Address> findAllAddress() {
        return this.addressRepository.findAll();
    }

    @GetMapping("/address/{id}")
    public Optional<Address> findAddressById(@PathVariable Long id) {
        return this.addressRepository.findById(id);
    }

    @PostMapping("/address")
    public Address saveAddress(@RequestBody Address item) {
        return this.addressRepository.save(item);
    }

    @DeleteMapping("/address")
    public void deleteAddress(@RequestBody Address item) {
        this.addressRepository.delete(item);
    }

    @DeleteMapping("/address/{id}")
    public void deleteAddress(@PathVariable Long id) {
        this.addressRepository.deleteById(id);
    }

}

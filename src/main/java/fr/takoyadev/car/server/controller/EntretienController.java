package fr.takoyadev.car.server.controller;

import fr.takoyadev.car.server.dao.EntretienRepository;
import fr.takoyadev.car.server.entity.Entretien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(value = "*")
@RestController
public class EntretienController {

    @Autowired
    private EntretienRepository entretienRepository;

    @GetMapping("/entretiens")
    public Iterable<Entretien> findEntretiens() {
        return this.entretienRepository.findAll();
    }

    @GetMapping("/entretiens/owner/{ownerId}")
    public List<Entretien> findEntretienByOwner(@PathVariable Long ownerId) {
        return this.entretienRepository.findByCarOwnerId(ownerId);
    }

    @GetMapping("/entretiens/car/{carId}")
    public List<Entretien> findEntretienByCar(@PathVariable Long carId) {
        return this.entretienRepository.findByCarId(carId);
    }

    @GetMapping("/entretiens/{id}")
    public Optional<Entretien> findEntretien(@PathVariable Long id) {
        return this.entretienRepository.findById(id);
    }

    @PostMapping(value = "/entretiens/add")
    public void saveEntretien(@RequestBody Entretien entretien) {
        this.entretienRepository.save(entretien);
    }

}

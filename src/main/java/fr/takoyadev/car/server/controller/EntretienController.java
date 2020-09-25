package fr.takoyadev.car.server.controller;

import fr.takoyadev.car.server.dao.EntretienRepository;
import fr.takoyadev.car.server.entity.Entretien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EntretienController {

    @Autowired
    private EntretienRepository entretienRepository;

    @GetMapping("/entretiens")
    public Iterable<Entretien> findEntretiens() {
        return this.entretienRepository.findAll();
    }

    @GetMapping("/entretiens/owner/{id}")
    public List<Entretien> findEntretienByOwner(@PathVariable Long id) {
        return this.entretienRepository.findByCarOwnerId(id);
    }

    @GetMapping("/entretiens/car/{id}")
    public List<Entretien> findEntretienByCar(@PathVariable Long id) {
        return this.entretienRepository.findByCarId(id);
    }

    @GetMapping("/entretien/{id}")
    public Optional<Entretien> findEntretien(@PathVariable Long id) {
        return this.entretienRepository.findById(id);
    }

    @PostMapping(value = "/entretien/add")
    public void saveEntretien(@RequestBody Entretien entretien) {
        this.entretienRepository.save(entretien);
    }

}

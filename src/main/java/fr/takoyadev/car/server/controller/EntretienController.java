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

    @RequestMapping("/entretiens")
    public Iterable<Entretien> findEntretiens() {
        return this.entretienRepository.findAll();
    }

    @RequestMapping("/entretiens/owner/{id}")
    public List<Entretien> findEntretienByOwner(@PathVariable Long id) {
        return this.entretienRepository.findByCarOwnerId(id);
    }

    @RequestMapping("/entretiens/car/{id}")
    public List<Entretien> findEntretienByCar(@PathVariable Long id) {
        return this.entretienRepository.findByCarId(id);
    }

    @RequestMapping("/entretien/{id}")
    public Optional<Entretien> findEntretien(@PathVariable Long id) {
        return this.entretienRepository.findById(id);
    }

    @RequestMapping(value = "/entretien/add", method = RequestMethod.POST)
    public void saveEntretien(@RequestBody Entretien entretien) {
        this.entretienRepository.save(entretien);
    }

}

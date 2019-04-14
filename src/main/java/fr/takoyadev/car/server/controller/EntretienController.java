package fr.takoyadev.car.server.controller;

import fr.takoyadev.car.server.dao.CarRepository;
import fr.takoyadev.car.server.dao.EntretienRepository;
import fr.takoyadev.car.server.entity.Car;
import fr.takoyadev.car.server.entity.Entretien;
import fr.takoyadev.car.server.entity.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@RestController
public class EntretienController {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private EntretienRepository entretienRepository;

    @RequestMapping("/")
    public List<Car> findAllCars() {
        return this.carRepository.findAll();
    }

    @RequestMapping("/car/{id}")
    public Optional<Car> findCar(@PathVariable Long id) {
        return this.carRepository.findById(id);
    }

    @RequestMapping("/entretien/owner/{id}")
    public List<Entretien> findEntretienByOwner(@PathVariable Long id) {
        return this.entretienRepository.findByOwnerId(id);
    }

    @RequestMapping(value = "/add/car", method = RequestMethod.POST)
    public void saveCar(@RequestBody Car car) {
        this.carRepository.save(car);
    }

    @RequestMapping(value = "/add/entretien", method = RequestMethod.POST)
    public void saveEntretien(@RequestBody Entretien entretien) {
        this.entretienRepository.save(entretien);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

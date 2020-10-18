package fr.takoyadev.car.server.controller;

import fr.takoyadev.car.server.dao.CarRepository;
import fr.takoyadev.car.server.entity.Car;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(value = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {

    @NonNull
    private CarRepository carRepository;

    @GetMapping()
    public Iterable<Car> findAllCar() { return this.carRepository.findAll(); }

    @GetMapping("/{id}")
    public Optional<Car> findCar(@PathVariable Long id) { return this.carRepository.findById(id); }

    @PostMapping()
    public void saveCar(@RequestBody Car car) {
        this.carRepository.save(car);
    }

    @DeleteMapping()
    public void deleteCar(@RequestBody Car item) {
        this.carRepository.delete(item);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) { this.carRepository.deleteById(id); }

}

package fr.takoyadev.car.server.controller;

import fr.takoyadev.car.server.dao.CarRepository;
import fr.takoyadev.car.server.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @RequestMapping("/cars")
    public Iterable<Car> findAllCars() {
        return this.carRepository.findAll();
    }

    @RequestMapping("/car/{id}")
    public Optional<Car> findCar(@PathVariable Long id) {
        return this.carRepository.findById(id);
    }

    @RequestMapping(value = "/car/add", method = RequestMethod.POST)
    public void saveCar(@RequestBody Car car) {
        this.carRepository.save(car);
    }
}

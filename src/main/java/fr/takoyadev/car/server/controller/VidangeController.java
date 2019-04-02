package fr.takoyadev.car.server.controller;

import fr.takoyadev.car.server.dao.CarRepository;
import fr.takoyadev.car.server.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VidangeController {

    @Autowired
    private CarRepository carRepository;

    @RequestMapping
    public List<Car> test() {
        return this.carRepository.findAll();
    }
}

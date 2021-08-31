package fr.takoyadev.car.back.controller;

import fr.takoyadev.car.back.entity.Car;
import fr.takoyadev.car.back.repository.CarRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {

    @NonNull
    private CarRepository repository;

    @GetMapping
    public Iterable<Car> list() {
        return repository.findAll();
    }

}

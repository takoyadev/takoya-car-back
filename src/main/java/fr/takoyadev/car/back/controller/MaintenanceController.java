package fr.takoyadev.car.back.controller;

import fr.takoyadev.car.back.configuration.SpringFoxConfig;
import fr.takoyadev.car.back.entity.Car;
import fr.takoyadev.car.back.entity.Maintenance;
import fr.takoyadev.car.back.repository.CarRepository;
import fr.takoyadev.car.back.repository.MaintenanceRepository;
import io.swagger.annotations.Api;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@Api(tags = {SpringFoxConfig.TAG_MAINTENANCES})
@RestController
@RequiredArgsConstructor
@RequestMapping("/maintenances")
public class MaintenanceController {

    @NonNull
    private MaintenanceRepository repository;

    @GetMapping
    public Iterable<Maintenance> list() {
        return repository.findAll();
    }

    @PostMapping
    public Maintenance add(@RequestBody final Maintenance item){
        return repository.save(item);
    }

    @PutMapping
    public Maintenance update(@RequestBody final Maintenance item) {
        return repository.save(item);
    }

    @DeleteMapping
    public void delete(@RequestBody final Maintenance item) {
        repository.delete(item);
    }

    @GetMapping("/{id}")
    public Maintenance show(@PathVariable("id") final Long id) {
        try {
            return repository.findById(id).get();
        } catch (final NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Maintenance not found", exception);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") final Long id) {
        try {
            repository.deleteById(id);
        } catch (final EmptyResultDataAccessException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Maintenance not found", exception);
        }
    }

}

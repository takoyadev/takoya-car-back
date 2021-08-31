package fr.takoyadev.car.back.controller;

import fr.takoyadev.car.back.configuration.SpringFoxConfig;
import fr.takoyadev.car.back.entity.Car;
import fr.takoyadev.car.back.entity.Owner;
import fr.takoyadev.car.back.repository.CarRepository;
import fr.takoyadev.car.back.repository.OwnerRepository;
import io.swagger.annotations.Api;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@Api(tags = {SpringFoxConfig.TAG_OWNERS})
@RestController
@RequiredArgsConstructor
@RequestMapping("/owners")
public class OwnerController {

    @NonNull
    private OwnerRepository repository;

    @GetMapping
    public Iterable<Owner> list() {
        return repository.findAll();
    }

    @PostMapping
    public Owner add(@RequestBody final Owner item){
        return repository.save(item);
    }

    @PutMapping
    public Owner update(@RequestBody final Owner item) {
        return repository.save(item);
    }

    @DeleteMapping
    public void delete(@RequestBody final Owner item) {
        repository.delete(item);
    }

    @GetMapping("/{id}")
    public Owner show(@PathVariable("id") final Long id) {
        try {
            return repository.findById(id).get();
        } catch (final NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Owner not found", exception);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") final Long id) {
        try {
            repository.deleteById(id);
        } catch (final EmptyResultDataAccessException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Owner not found", exception);
        }
    }

}

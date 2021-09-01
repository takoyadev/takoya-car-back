package fr.takoyadev.car.back.controller;

import fr.takoyadev.car.back.configuration.SpringFoxConfig;
import fr.takoyadev.car.back.entity.Car;
import fr.takoyadev.car.back.entity.Label;
import fr.takoyadev.car.back.repository.CarRepository;
import fr.takoyadev.car.back.repository.LabelRepository;
import io.swagger.annotations.Api;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@Api(tags = {SpringFoxConfig.TAG_LABELS})
@RestController
@RequiredArgsConstructor
@RequestMapping("/labels")
public class LabelController {

    @NonNull
    private LabelRepository repository;

    @GetMapping
    public Iterable<Label> list() {
        return repository.findAll();
    }

    @PostMapping
    public Label add(@RequestBody final Label item){
        return repository.save(item);
    }

    @PutMapping
    public Label update(@RequestBody final Label item) {
        return repository.save(item);
    }

    @DeleteMapping
    public void delete(@RequestBody final Label item) {
        repository.delete(item);
    }

    @GetMapping("/{id}")
    public Label show(@PathVariable("id") final Long id) {
        try {
            return repository.findById(id).get();
        } catch (final NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Car not found", exception);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") final Long id) {
        try {
            repository.deleteById(id);
        } catch (final EmptyResultDataAccessException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Car not found", exception);
        }
    }

}

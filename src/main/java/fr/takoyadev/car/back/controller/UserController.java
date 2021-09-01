package fr.takoyadev.car.back.controller;

import fr.takoyadev.car.back.configuration.SpringFoxConfig;
import fr.takoyadev.car.back.entity.Car;
import fr.takoyadev.car.back.entity.User;
import fr.takoyadev.car.back.repository.CarRepository;
import fr.takoyadev.car.back.repository.UserRepository;
import io.swagger.annotations.Api;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@Api(tags = {SpringFoxConfig.TAG_USERS})
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    @NonNull
    private UserRepository repository;

    @GetMapping
    public Iterable<User> list() {
        return repository.findAll();
    }

    @PostMapping
    public User add(@RequestBody final User item){
        return repository.save(item);
    }

    @PutMapping
    public User update(@RequestBody final User item) {
        return repository.save(item);
    }

    @DeleteMapping
    public void delete(@RequestBody final User item) {
        repository.delete(item);
    }

    @GetMapping("/{id}")
    public User show(@PathVariable("id") final Long id) {
        try {
            return repository.findById(id).get();
        } catch (final NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found", exception);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") final Long id) {
        try {
            repository.deleteById(id);
        } catch (final EmptyResultDataAccessException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found", exception);
        }
    }

}

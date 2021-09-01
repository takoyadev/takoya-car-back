package fr.takoyadev.car.back.controller;

import fr.takoyadev.car.back.configuration.SpringFoxConfig;
import fr.takoyadev.car.back.entity.Car;
import fr.takoyadev.car.back.entity.Role;
import fr.takoyadev.car.back.repository.CarRepository;
import fr.takoyadev.car.back.repository.RoleRepository;
import io.swagger.annotations.Api;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@Api(tags = {SpringFoxConfig.TAG_ROLES})
@RestController
@RequiredArgsConstructor
@RequestMapping("/roles")
public class RoleController {

    @NonNull
    private RoleRepository repository;

    @GetMapping
    public Iterable<Role> list() {
        return repository.findAll();
    }

    @PostMapping
    public Role add(@RequestBody final Role item){
        return repository.save(item);
    }

    @PutMapping
    public Role update(@RequestBody final Role item) {
        return repository.save(item);
    }

    @DeleteMapping
    public void delete(@RequestBody final Role item) {
        repository.delete(item);
    }

    @GetMapping("/{id}")
    public Role show(@PathVariable("id") final Long id) {
        try {
            return repository.findById(id).get();
        } catch (final NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Role not found", exception);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") final Long id) {
        try {
            repository.deleteById(id);
        } catch (final EmptyResultDataAccessException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Role not found", exception);
        }
    }

}

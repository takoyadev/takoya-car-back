package fr.takoyadev.car.back.controller;

import fr.takoyadev.car.back.configuration.SpringFoxConfiguration;
import fr.takoyadev.car.back.constants.SecurityConst;
import fr.takoyadev.car.back.entity.Maintenance;
import fr.takoyadev.car.back.repository.MaintenanceRepository;
import io.swagger.annotations.Api;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@Api(tags = {SpringFoxConfiguration.TAG_MAINTENANCES})
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/maintenances")
public class MaintenanceController {

    @NonNull
    private MaintenanceRepository repository;

    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_" + SecurityConst.SCOPE_READ_MAINTENANCE + "')")
    public Iterable<Maintenance> list() {
        return repository.findAll();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('SCOPE_" + SecurityConst.SCOPE_WRITE_MAINTENANCE + "')")
    public Maintenance add(@RequestBody final Maintenance item){
        return repository.save(item);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('SCOPE_" + SecurityConst.SCOPE_WRITE_MAINTENANCE + "')")
    public Maintenance update(@RequestBody final Maintenance item) {
        return repository.save(item);
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('SCOPE_" + SecurityConst.SCOPE_WRITE_MAINTENANCE + "')")
    public void delete(@RequestBody final Maintenance item) {
        repository.delete(item);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_" + SecurityConst.SCOPE_READ_MAINTENANCE + "')")
    public Maintenance show(@PathVariable("id") final Long id) {
        try {
            return repository.findById(id).get();
        } catch (final NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Maintenance not found", exception);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_" + SecurityConst.SCOPE_WRITE_MAINTENANCE + "')")
    public void delete(@PathVariable("id") final Long id) {
        try {
            repository.deleteById(id);
        } catch (final EmptyResultDataAccessException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Maintenance not found", exception);
        }
    }

}

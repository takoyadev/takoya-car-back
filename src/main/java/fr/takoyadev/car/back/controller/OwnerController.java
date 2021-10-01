package fr.takoyadev.car.back.controller;

import fr.takoyadev.car.back.configuration.SpringFoxConfiguration;
import fr.takoyadev.car.back.constants.SecurityConst;
import fr.takoyadev.car.back.entity.Owner;
import fr.takoyadev.car.back.repository.OwnerRepository;
import io.swagger.annotations.Api;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@Api(tags = {SpringFoxConfiguration.TAG_OWNERS})
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/owners")
public class OwnerController {

    @NonNull
    private OwnerRepository repository;

    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_" + SecurityConst.SCOPE_READ_OWNER + "')")
    public Iterable<Owner> list() {
        return repository.findAll();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('SCOPE_" + SecurityConst.SCOPE_WRITE_OWNER + "')")
    public Owner add(@RequestBody final Owner item){
        return repository.save(item);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('SCOPE_" + SecurityConst.SCOPE_WRITE_OWNER + "')")
    public Owner update(@RequestBody final Owner item) {
        return repository.save(item);
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('SCOPE_" + SecurityConst.SCOPE_WRITE_OWNER + "')")
    public void delete(@RequestBody final Owner item) {
        repository.delete(item);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_" + SecurityConst.SCOPE_READ_OWNER + "')")
    public Owner show(@PathVariable("id") final Long id) {
        try {
            return repository.findById(id).get();
        } catch (final NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Owner not found", exception);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_" + SecurityConst.SCOPE_WRITE_OWNER + "')")
    public void delete(@PathVariable("id") final Long id) {
        try {
            repository.deleteById(id);
        } catch (final EmptyResultDataAccessException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Owner not found", exception);
        }
    }

}

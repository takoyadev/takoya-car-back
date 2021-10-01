package fr.takoyadev.car.back.controller;

import fr.takoyadev.car.back.configuration.SpringFoxConfiguration;
import fr.takoyadev.car.back.constants.SecurityConst;
import fr.takoyadev.car.back.entity.Label;
import fr.takoyadev.car.back.repository.LabelRepository;
import io.swagger.annotations.Api;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@Api(tags = {SpringFoxConfiguration.TAG_LABELS})
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/labels")
public class LabelController {

    @NonNull
    private LabelRepository repository;

    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_" + SecurityConst.SCOPE_READ_LABEL + "')")
    public Iterable<Label> list() {
        return repository.findAll();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('SCOPE_" + SecurityConst.SCOPE_WRITE_LABEL + "')")
    public Label add(@RequestBody final Label item){
        return repository.save(item);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('SCOPE_" + SecurityConst.SCOPE_WRITE_LABEL + "')")
    public Label update(@RequestBody final Label item) {
        return repository.save(item);
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('SCOPE_" + SecurityConst.SCOPE_WRITE_LABEL + "')")
    public void delete(@RequestBody final Label item) {
        repository.delete(item);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_" + SecurityConst.SCOPE_READ_LABEL + "')")
    public Label show(@PathVariable("id") final Long id) {
        try {
            return repository.findById(id).get();
        } catch (final NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Car not found", exception);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_" + SecurityConst.SCOPE_WRITE_LABEL + "')")
    public void delete(@PathVariable("id") final Long id) {
        try {
            repository.deleteById(id);
        } catch (final EmptyResultDataAccessException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Car not found", exception);
        }
    }

}

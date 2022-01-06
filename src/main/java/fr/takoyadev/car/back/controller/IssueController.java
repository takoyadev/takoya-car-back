package fr.takoyadev.car.back.controller;

import fr.takoyadev.car.back.configuration.SpringFoxConfiguration;
import fr.takoyadev.car.back.constants.SecurityConst;
import fr.takoyadev.car.back.entity.Issue;
import fr.takoyadev.car.back.repository.IssueRepository;
import io.swagger.annotations.Api;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@Api(tags = {SpringFoxConfiguration.TAG_ISSUES})
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/issues")
public class IssueController {

    @NonNull
    private IssueRepository repository;

    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_" + SecurityConst.SCOPE_READ_ISSUES + "')")
    public Iterable<Issue> list() {
        return repository.findAll();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('SCOPE_" + SecurityConst.SCOPE_WRITE_ISSUES + "')")
    public Issue add(@RequestBody final Issue item){
        return repository.save(item);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('SCOPE_" + SecurityConst.SCOPE_WRITE_ISSUES + "')")
    public Issue update(@RequestBody final Issue item) {
        return repository.save(item);
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('SCOPE_" + SecurityConst.SCOPE_WRITE_ISSUES + "')")
    public void delete(@RequestBody final Issue item) {
        repository.delete(item);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_" + SecurityConst.SCOPE_READ_ISSUES + "')")
    public Issue show(@PathVariable("id") final Long id) {
        try {
            return repository.findById(id).get();
        } catch (final NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Issue not found", exception);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_" + SecurityConst.SCOPE_WRITE_ISSUES + "')")
    public void delete(@PathVariable("id") final Long id) {
        try {
            repository.deleteById(id);
        } catch (final EmptyResultDataAccessException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Issue not found", exception);
        }
    }

}

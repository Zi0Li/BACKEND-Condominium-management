package br.com.smartcondo.controllers;

import br.com.smartcondo.models.AuthorizedPersons;
import br.com.smartcondo.records.ResidentAllDetailsDTO;
import br.com.smartcondo.services.AuthorizedPersonsService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authorizedPersons")
public class AuthorizedPersonsController {

    @Autowired
    private AuthorizedPersonsService service = new AuthorizedPersonsService();

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AuthorizedPersons> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AuthorizedPersons findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }

    @GetMapping(value = "/resident={id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AuthorizedPersons> findByIdResident(@PathVariable(value = "id") int id) {
        return service.findByIdResident(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public AuthorizedPersons create(@RequestBody AuthorizedPersons authorizedPersons) {
        return service.create(authorizedPersons);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public AuthorizedPersons update(@RequestBody AuthorizedPersons authorizedPersons) {
        return service.update(authorizedPersons);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
    }


    @Transactional
    @GetMapping(value = "/search/{search}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResidentAllDetailsDTO findByCpfOrRg(@PathVariable(value = "search") String search) {
        return service.findByCpfOrRg(search);
    }
}

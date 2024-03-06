package br.com.smartcondo.controllers;

import br.com.smartcondo.models.AuthorizedPersons;
import br.com.smartcondo.services.AuthorizedPersonsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/AuthorizedPersons")
public class AuthorizedPersonsController {

    @Autowired
    private AuthorizedPersonsServices service = new AuthorizedPersonsServices();

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AuthorizedPersons> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AuthorizedPersons findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }
}

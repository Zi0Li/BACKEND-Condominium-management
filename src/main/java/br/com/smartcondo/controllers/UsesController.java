package br.com.smartcondo.controllers;

import br.com.smartcondo.models.Resident;
import br.com.smartcondo.models.Users;
import br.com.smartcondo.services.UsersServices;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsesController {

    @Autowired
    private UsersServices service = new UsersServices();

    @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Users> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Users findById(@PathVariable(value = "id") long id) {
        return service.findById(id);
    }


    @PostMapping(produces= MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Users create(@RequestBody Users user) {
        return service.create(user);
    }


    @PutMapping(produces= MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Users update(@RequestBody Users user) {
        return service.update(user);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
    }

}

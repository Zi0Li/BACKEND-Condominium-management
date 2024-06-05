package br.com.smartcondo.controllers;

import br.com.smartcondo.models.Syndicate;
import br.com.smartcondo.services.SyndicateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/syndicate")
public class SyndicateController {

    @Autowired
    private SyndicateService service;

    @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Syndicate> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}",produces= MediaType.APPLICATION_JSON_VALUE)
    public Syndicate findById(@PathVariable(value = "id") long id){
        return service.findById(id);
    }

    @PostMapping(produces= MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Syndicate create(@RequestBody Syndicate syndicate){
        return service.create(syndicate);
    }

    @PutMapping(produces= MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Syndicate update(@RequestBody Syndicate syndicate){
        return service.update(syndicate);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") long id){
        service.delete(id);
    }
}

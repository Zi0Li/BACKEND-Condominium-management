package br.com.smartcondo.controllers;

import br.com.smartcondo.models.Condominium;
import br.com.smartcondo.services.CondominiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/condominium")
public class CondominiumController {

    @Autowired
    private CondominiumService service = new CondominiumService();

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Condominium> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Condominium findById(@PathVariable(value = "id") long id) {
        return service.findById(id);
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Condominium create(@RequestBody Condominium condominium) {
        return service.create(condominium);
    }


    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Condominium update(@RequestBody Condominium condominium) {
        return service.update(condominium);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
    }

}

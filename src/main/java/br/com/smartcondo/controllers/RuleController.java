package br.com.smartcondo.controllers;

import br.com.smartcondo.models.Rule;
import br.com.smartcondo.records.ResidentAllDetailsDTO;
import br.com.smartcondo.services.RuleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rule")
public class RuleController {

    @Autowired
    private RuleService service = new RuleService();

    @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Rule> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Rule findById(@PathVariable(value = "id") long id) {
        return service.findById(id);
    }

    @Transactional
    @GetMapping(value = "/condominium={id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Rule> findByIdCondominium(@PathVariable(value = "id") long id) {
        return service.findByIdCondominium(id);
    }

    @PostMapping(produces= MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Rule create(@RequestBody Rule rule) {
        return service.create(rule);
    }

    @PutMapping(produces= MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Rule update(@RequestBody Rule rule) {
        return service.update(rule);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
    }
}

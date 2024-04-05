package br.com.smartcondo.controllers;

import br.com.smartcondo.models.CondominiumAddress;
import br.com.smartcondo.services.CondominiumAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/condominiumAddress")
public class CondominiumAddressController {

    @Autowired
    private CondominiumAddressService service = new CondominiumAddressService();

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CondominiumAddress> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CondominiumAddress findById(@PathVariable(value = "id") long id) {
        return service.findById(id);
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public CondominiumAddress create(@RequestBody CondominiumAddress condominiumAddress) {
        return service.create(condominiumAddress);
    }


    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public CondominiumAddress update(@RequestBody CondominiumAddress condominiumAddress) {
        return service.update(condominiumAddress);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
    }

}

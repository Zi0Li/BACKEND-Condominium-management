package br.com.smartcondo.controllers;

import br.com.smartcondo.models.Resident;
import br.com.smartcondo.records.ResidentAllDetailsDTO;
import br.com.smartcondo.services.ResidentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resident")
public class ResidentController {

    @Autowired
    private ResidentService service = new ResidentService();

    @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Resident> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Resident findById(@PathVariable(value = "id") long id) {
        return service.findById(id);
    }

    @Transactional
    @GetMapping(value = "/condominium={id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<ResidentAllDetailsDTO> findByIdCondominium(@PathVariable(value = "id") long id) {
        return service.findByIdCondominium(id);
    }

    @PostMapping(produces= MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Resident create(@RequestBody Resident resident) {
        return service.create(resident);
    }

    @GetMapping(value = "/{id}/neighbors", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Resident> findNeighbors(@PathVariable(value = "id") long id) {
        return service.findNeighbors(id);
    }

    @PutMapping(produces= MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Resident update(@RequestBody Resident resident) {
        return service.update(resident);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
    }
}

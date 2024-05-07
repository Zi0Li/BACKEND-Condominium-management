package br.com.smartcondo.controllers;


import br.com.smartcondo.models.Vehicle;
import br.com.smartcondo.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService service = new VehicleService();

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vehicle> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Vehicle findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }

    @GetMapping(value = "/resident={id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vehicle> findByIdResident(@PathVariable(value = "id") Long id) {
        return service.findByIdResident(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Vehicle create(@RequestBody Vehicle vehicle) {
        return service.create(vehicle);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Vehicle update(@RequestBody Vehicle vehicle) {
        return service.update(vehicle);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
    }
}

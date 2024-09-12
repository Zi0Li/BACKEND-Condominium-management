package br.com.smartcondo.controllers;

import br.com.smartcondo.models.Kiosk;
import br.com.smartcondo.records.ReservationAndKioskDTO;
import br.com.smartcondo.services.KioskService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kiosk")
public class KioskController {

    @Autowired
    private KioskService service = new KioskService();

    @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Kiosk> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Kiosk findById(@PathVariable(value = "id") long id) {
        return service.findById(id);
    }

    @GetMapping(value = "/condominium={id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Kiosk> findByIdCondominium(@PathVariable(value = "id") long id) {
        return service.findByIdCondominium(id);
    }

    @PostMapping(produces= MediaType.APPLICATION_JSON_VALUE,
            consumes = {"application/json"})
    public Kiosk create(@RequestBody Kiosk kiosk) {
        return service.create(kiosk);
    }


    @PutMapping(produces= MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Kiosk update(@RequestBody Kiosk kiosk) {
        return service.update(kiosk);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
    }

    @GetMapping(value = "/resident={id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Kiosk> findByIdResident(@PathVariable(value = "id") long id) {
        return service.findByIdResident(id);
    }

    @Transactional
    @GetMapping(value = "/all/{id}",produces= MediaType.APPLICATION_JSON_VALUE)
    public List<ReservationAndKioskDTO> findAllDetails(@PathVariable(value = "id") Long id) {
        return service.findAllDetails(id);
    }
}

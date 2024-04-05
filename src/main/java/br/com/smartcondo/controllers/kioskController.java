package br.com.smartcondo.controllers;

import br.com.smartcondo.models.Kiosk;
import br.com.smartcondo.models.Resident;
import br.com.smartcondo.services.KioskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kiosk")
public class kioskController {

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


    @PostMapping(produces= MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
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

}

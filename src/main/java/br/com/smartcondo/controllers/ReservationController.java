package br.com.smartcondo.controllers;

import br.com.smartcondo.models.Reservation;
import br.com.smartcondo.records.ReservationAndKioskDTO;
import br.com.smartcondo.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    ReservationService service = new ReservationService();

    @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Reservation> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Reservation findById(@PathVariable(value = "id") long id) {
        return service.findById(id);
    }

    @PostMapping(produces= MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Reservation create(@RequestBody Reservation reservation) {
        return service.create(reservation);
    }


    @PutMapping(produces= MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Reservation update(@RequestBody Reservation reservation) {
        return service.update(reservation);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
    }

    @GetMapping(value = "/resident={id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<ReservationAndKioskDTO> findByIdResident(@PathVariable(value = "id") long id) {
        return service.findByIdResident(id);
    }
}
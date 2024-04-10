package br.com.smartcondo.controllers;

import br.com.smartcondo.models.Notification;
import br.com.smartcondo.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotificationService service = new NotificationService();

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Notification> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Notification findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }

    @GetMapping(value = "/condominium={id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Notification> findByIdCondominium(@PathVariable(value = "id") long id) {
        return service.findByIdCondominium(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Notification create(@RequestBody Notification notification) {
        return service.create(notification);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Notification update(@RequestBody Notification notification) {
        return service.update(notification);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
    }

}

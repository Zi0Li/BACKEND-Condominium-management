package br.com.smartcondo.controllers;

import br.com.smartcondo.models.Correspondence;
import br.com.smartcondo.models.Resident;
import br.com.smartcondo.records.CorrespondenceDTO;
import br.com.smartcondo.services.CorrespondenceService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/correspondence")
public class CorrespondenceController {

    @Autowired
    private CorrespondenceService service = new CorrespondenceService();

    @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Correspondence> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}",produces= MediaType.APPLICATION_JSON_VALUE)
    public Correspondence findById(@PathVariable(value = "id") long id) {
        return service.findById(id);
    }

    @GetMapping(value = "/resident={id}",produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Correspondence> findByResident(@PathVariable(value = "id") long id) {
        return service.findByIdUser(id);
    }

    @Transactional
    @GetMapping(value = "/condominium={id}",produces= MediaType.APPLICATION_JSON_VALUE)
    public List<CorrespondenceDTO> findByCondominium(@PathVariable(value = "id") long id) {
        return service.findByIdCondominium(id);
    }

    @PostMapping(produces= MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Correspondence create(@RequestBody Correspondence correspondence){return service.create(correspondence);}

    @PutMapping(produces= MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Correspondence update(@RequestBody Correspondence correspondence){return service.update(correspondence);}

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
    }

}

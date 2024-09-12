package br.com.smartcondo.controllers;

import br.com.smartcondo.models.Report;
import br.com.smartcondo.records.ReportDTO;
import br.com.smartcondo.services.ReportService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService service = new ReportService();

    @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Report> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Report findById(@PathVariable(value = "id") long id) {
        return service.findById(id);
    }

    @Transactional
    @GetMapping(value = "/condominium={id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<ReportDTO> findByIdCondominium(@PathVariable(value = "id") long id) {
        return service.findByIdCondominium(id);
    }

    @GetMapping(value = "/resident={id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Report> findByIdResident(@PathVariable(value = "id") long id) {
        return service.findByIdResident(id);
    }

    @PostMapping(produces= MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Report create(@RequestBody Report report) {
        return service.create(report);
    }

    @PutMapping(produces= MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Report update(@RequestBody Report report) {
        return service.update(report);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
    }

}

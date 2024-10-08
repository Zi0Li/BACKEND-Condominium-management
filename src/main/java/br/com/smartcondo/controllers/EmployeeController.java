package br.com.smartcondo.controllers;

import br.com.smartcondo.models.Employees;
import br.com.smartcondo.records.EmployeeAllDetailsDTO;
import br.com.smartcondo.services.EmployeeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employees> findAll() {
        return employeeService.findAll();
    }

    @Transactional
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeAllDetailsDTO findByID(@PathVariable(value = "id") Long id) {
        return employeeService.findById(id);
    }

    @GetMapping(value = "/condominium={id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Employees> findByIdCondominium(@PathVariable(value = "id") long id) {
        return employeeService.findByIdCondominium(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Employees create(@RequestBody Employees employees) {
        return employeeService.create(employees);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Employees update(@RequestBody Employees employees) {
        return employeeService.update(employees);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        employeeService.delete(id);
    }
}

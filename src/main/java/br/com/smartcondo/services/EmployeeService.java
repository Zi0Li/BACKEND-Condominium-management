package br.com.smartcondo.services;

import br.com.smartcondo.exceptions.ResourceNotFoundException;
import br.com.smartcondo.models.Employees;
import br.com.smartcondo.repositories.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class EmployeeService {
    private Logger logger = Logger.getLogger(EmployeeService.class.getName());

    @Autowired
    EmployeesRepository employeesRepository;


    public List<Employees> findAll(){

        logger.info("Finding all employees!");

        return employeesRepository.findAll();
    }

    public Employees findById(Long id){

        logger.info("Finding one employee!");

        return employeesRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
    }

    public List<Employees> findByIdCondominium(Long id){
        logger.info("Finding all employees this condominium");

        return employeesRepository.findByCondominium_id(id);
    }

    public Employees update(Employees employees){

        logger.info("Updating one employee!");

        Employees entity = employeesRepository.findById(employees.getId()).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));

        entity.setName(employees.getName());
        entity.setCpf(employees.getCpf());
        entity.setPhone(employees.getPhone());
        entity.setRg(employees.getRg());
        entity.setPosition(employees.getPosition());
        entity.setWorkload(employees.getWorkload());

        return employeesRepository.save(employees);
    }

    public void delete(Long id){

        logger.info("Deleting one employee!");

        Employees entity = employeesRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));

        employeesRepository.delete(entity);
    }

    public Employees create(Employees employees){

        logger.info("Creating one employee!");

        return employeesRepository.save(employees);
    }
}

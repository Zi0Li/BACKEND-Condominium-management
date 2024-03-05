package br.com.smartcondo.services;

import br.com.smartcondo.exceptions.ResourceNotFoundException;
import br.com.smartcondo.models.Resident;
import br.com.smartcondo.repositories.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ResidentServices {

    private Logger logger = Logger.getLogger(ResidentServices.class.getName());

    @Autowired
    ResidentRepository repository;

    public List<Resident> findAll() {
        logger.info("Finding all peoples!");

        return repository.findAll();
    }

    public Resident findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    public Resident update(Resident resident) {

        logger.info("Updating one resident!");

        Resident entity = repository.findById(resident.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setName(resident.getName());
        entity.setRg(resident.getRg());
        entity.setCpf(resident.getCpf());
        entity.setAge(resident.getAge());
        entity.setPhone(resident.getPhone());

        return repository.save(resident);
    }

    public void delete(Long id) {

        logger.info("Deleting one resident!");

        Resident entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        repository.delete(entity);
    }

    public Resident create(Resident resident) {

        logger.info("Creating one resident!");

        return repository.save(resident);
    }
}

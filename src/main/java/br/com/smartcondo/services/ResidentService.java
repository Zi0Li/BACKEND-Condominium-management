package br.com.smartcondo.services;

import br.com.smartcondo.exceptions.ResourceNotFoundException;
import br.com.smartcondo.models.Resident;
import br.com.smartcondo.repositories.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ResidentService {
    private Logger logger = Logger.getLogger(ResidentService.class.getName());

    @Autowired
    ResidentRepository residentRepository;

    public List<Resident> findAll() {
        logger.info("Finding all peoples!");

        return residentRepository.findAll();
    }

    public Resident findById(Long id) {
        logger.info("Finding one people!");

        return residentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    public Resident update(Resident resident) {

        logger.info("Updating one resident!");

        Resident entity = residentRepository.findById(resident.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setName(resident.getName());
        entity.setRg(resident.getRg());
        entity.setCpf(resident.getCpf());
        entity.setAge(resident.getAge());
        entity.setEmail(resident.getEmail());
        entity.setPhone(resident.getPhone());

        return residentRepository.save(resident);
    }

    public void delete(Long id) {

        logger.info("Deleting one resident!");

        Resident entity = residentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        residentRepository.delete(entity);
    }

    public Resident create(Resident resident) {

        logger.info("Creating one resident!");

        return residentRepository.save(resident);
    }
}

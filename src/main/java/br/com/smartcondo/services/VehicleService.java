package br.com.smartcondo.services;

import br.com.smartcondo.exceptions.ResourceNotFoundException;
import br.com.smartcondo.models.Vehicle;
import br.com.smartcondo.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class VehicleService {

    private Logger logger = Logger.getLogger(ResidentService.class.getName());

    @Autowired
    VehicleRepository repository;

    public List<Vehicle> findAll() {
        logger.info("Finding all vehicles!");

        return repository.findAll();
    }

    public Vehicle findById(Long id) {
        logger.info("Finding one vehicle!");

        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    public List<Vehicle> findByIdResident(Long id) {
        logger.info("Finding one vehicle!");

        return repository.findByResident_id(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this RESIDENT ID"));
    }

    public Vehicle update(Vehicle vehicle) {
        logger.info("Updating one vehicle!");

        Vehicle entity = repository.findById(vehicle.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setBrand(vehicle.getBrand());
        entity.setColor(vehicle.getColor());
        entity.setModel(vehicle.getModel());
        entity.setType(vehicle.getType());
        entity.setPlate(vehicle.getPlate());
        entity.setYear(vehicle.getYear());

        return repository.save(vehicle);
    }

    public void delete(Long id) {

        logger.info("Deleting one resident!");

        Vehicle entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        repository.delete(entity);
    }

    public Vehicle create(Vehicle vehicle) {

        logger.info("Creating one resident!");

        return repository.save(vehicle);
    }
}

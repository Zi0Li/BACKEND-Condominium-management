package br.com.smartcondo.services;

import br.com.smartcondo.exceptions.ResourceNotFoundException;
import br.com.smartcondo.models.CondominiumAddress;
import br.com.smartcondo.repositories.CondominiumAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class CondominiumAddressService {
    Logger logger = Logger.getLogger(CondominiumAddressService.class.getName());

    @Autowired
    CondominiumAddressRepository condominiumAddressRepository;

    public List<CondominiumAddress> findAll(){
        logger.info("Finding all address!");

        return condominiumAddressRepository.findAll();
    }

    public CondominiumAddress findById(Long id){
        logger.info("Finding one address");

        return condominiumAddressRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
    }

    public CondominiumAddress update(CondominiumAddress condominiumAddress){
        logger.info("Updating one address!");

        CondominiumAddress entity = condominiumAddressRepository.findById(condominiumAddress.getId()).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));

        entity.setBlock(condominiumAddress.getBlock());
        entity.setCep(condominiumAddress.getCep());
        entity.setCity(condominiumAddress.getCity());
        entity.setDistrict(condominiumAddress.getDistrict());
        entity.setNumber_address(condominiumAddress.getNumber_address());
        entity.setReference(condominiumAddress.getReference());
        entity.setUf(condominiumAddress.getUf());
        entity.setStreet(condominiumAddress.getStreet());
        entity.setNumber_apt(condominiumAddress.getNumber_apt());

        return condominiumAddressRepository.save(condominiumAddress);
    }

    public void delete(Long id){
        logger.info("Deleting one address!");

        CondominiumAddress entity = condominiumAddressRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID!"));

        condominiumAddressRepository.delete(entity);
    }

    public CondominiumAddress create(CondominiumAddress condominiumAddress){
        logger.info("Creating one address!");

        return condominiumAddressRepository.save(condominiumAddress);
    }

}

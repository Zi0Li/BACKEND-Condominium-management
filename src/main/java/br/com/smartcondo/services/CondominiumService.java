package br.com.smartcondo.services;

import br.com.smartcondo.exceptions.ResourceNotFoundException;
import br.com.smartcondo.models.Condominium;
import br.com.smartcondo.repositories.CondominiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class CondominiumService {

    Logger logger = Logger.getLogger(CondominiumService.class.getName());

    @Autowired
    CondominiumRepository condominiumRepository;

    public List<Condominium> findAll() {
        logger.info("Finding all condominium");

        return condominiumRepository.findAll();
    }

    public Condominium findById(Long id){
        logger.info("Finding one condominium");

        return condominiumRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
    }

    public Condominium findByCode(int code){
        logger.info("Finding one condominium");

        return condominiumRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("No records found for this CODE"));
    }

    public Condominium update(Condominium condominium){
        logger.info("Updating one condominium");

        Condominium entity = condominiumRepository.findById(condominium.getId()).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));

        entity.setName(condominium.getName());
        entity.setCnpj(condominium.getCnpj());
        entity.setBlock(condominium.getBlock());
        entity.setCep(condominium.getCep());
        entity.setCity(condominium.getCity());
        entity.setDistrict(condominium.getDistrict());
        entity.setNumber_address(condominium.getNumber_address());
        entity.setReference(condominium.getReference());
        entity.setUf(condominium.getUf());
        entity.setStreet(condominium.getStreet());
        entity.setNumber_apt(condominium.getNumber_apt());

        return condominiumRepository.save(condominium);
    }

    public void delete(Long id){
        logger.info("Deleting one condominium");

        Condominium entity = condominiumRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));

        condominiumRepository.delete(entity);
    }

    public Condominium create(Condominium condominium){
        logger.info("Creating one condominium");

        return condominiumRepository.save(condominium);
    }
}
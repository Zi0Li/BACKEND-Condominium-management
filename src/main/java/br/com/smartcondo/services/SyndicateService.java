package br.com.smartcondo.services;

import br.com.smartcondo.exceptions.ResourceNotFoundException;
import br.com.smartcondo.models.Syndicate;
import br.com.smartcondo.repositories.SyndicateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class SyndicateService {
    private Logger logger = Logger.getLogger(SyndicateService.class.getName());

    @Autowired
    SyndicateRepository syndicateRepository;

    public List<Syndicate> findAll(){
        logger.info("Finding all syndicate");

        return syndicateRepository.findAll();
    }

    public Syndicate findById(Long id){
        logger.info("Finding one syndicate");

        return syndicateRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
    }

    public Syndicate update(Syndicate syndicate){

        logger.info("Updating one syndicate");

        Syndicate entity = syndicateRepository.findById(syndicate.getId()).orElseThrow(()-> new ResourceNotFoundException("JNo records found for this ID"));

        entity.setName(syndicate.getName());
        entity.setCpf(syndicate.getCpf());
        entity.setRg(syndicate.getRg());
        entity.setPhone(syndicate.getPhone());

        return syndicateRepository.save(syndicate);
    }

    public void delete(Long id){
        logger.info("Deleting one syndicate");

        Syndicate syndicate = syndicateRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));

        syndicateRepository.delete(syndicate);
    }

    public Syndicate create(Syndicate syndicate){

        logger.info("Creating one syndicate!");

        return syndicateRepository.save(syndicate);

    }
}
package br.com.smartcondo.services;

import br.com.smartcondo.exceptions.ResourceNotFoundException;
import br.com.smartcondo.models.Resident;
import br.com.smartcondo.models.Rule;
import br.com.smartcondo.records.ResidentAllDetailsDTO;
import br.com.smartcondo.repositories.RuleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class RuleService {
    private Logger logger = Logger.getLogger(ResidentService.class.getName());

    @Autowired
    RuleRepository repository;

    public List<Rule> findAll() {
        logger.info("Finding all rules!");

        return repository.findAll();
    }

    public Rule findById(Long id){
        logger.info("Finding one rule!");

        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    public Rule update(Rule rule){
        logger.info("Updating one rule!");

        Rule entity = repository.findById(rule.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setContent(rule.getContent());
        entity.setTitle(rule.getTitle());

        return repository.save(rule);
    }

    public void delete(Long id) {

        logger.info("Deleting one rule!");

        Rule entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        repository.delete(entity);
    }

    public Rule create(Rule rule) {

        logger.info("Creating one rule!");

        return repository.save(rule);
    }

    public List<Rule> findByIdCondominium(Long id){
        logger.info("Finding all rule this condominium");

        return repository.findByCondominium_id(id);
    }
}

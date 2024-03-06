package br.com.smartcondo.services;

import br.com.smartcondo.exceptions.ResourceNotFoundException;
import br.com.smartcondo.models.AuthorizedPersons;
import br.com.smartcondo.models.Resident;
import br.com.smartcondo.repositories.AuthorizedPersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class AuthorizedPersonsServices {

    private Logger logger = Logger.getLogger(AuthorizedPersonsServices.class.getName());

    @Autowired
    AuthorizedPersonsRepository repository;

    public List<AuthorizedPersons> findAll() {
        logger.info("Finding all authorized persons!");

        return repository.findAll();
    }

    public AuthorizedPersons findById(Long id) {
        logger.info("Finding one authorized persons!");

        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    public AuthorizedPersons update(AuthorizedPersons authorizedPersons) {

        logger.info("Updating one authorized person!");

        AuthorizedPersons entity = repository.findById(authorizedPersons.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setName(authorizedPersons.getName());
        entity.setRg(authorizedPersons.getRg());
        entity.setCpf(authorizedPersons.getCpf());
        entity.setKinship(authorizedPersons.getKinship());
        entity.setPhone(authorizedPersons.getPhone());

        return repository.save(authorizedPersons);
    }

    public void delete(Long id) {

        logger.info("Deleting one authorized person!");

        AuthorizedPersons entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        repository.delete(entity);
    }

    public AuthorizedPersons create(AuthorizedPersons authorizedPersons) {

        logger.info("Creating one authorized person!");

        return repository.save(authorizedPersons);
    }
}

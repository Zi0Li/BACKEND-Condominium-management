package br.com.smartcondo.services;

import br.com.smartcondo.exceptions.ResourceNotFoundException;
import br.com.smartcondo.models.Users;
import br.com.smartcondo.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class UsersServices {

    private Logger logger = Logger.getLogger(UsersServices.class.getName());

    @Autowired
    UsersRepository repository;

    public List<Users> findAll(){
        logger.info("Finding all users!");

        return repository.findAll();
    }

    public Users findById(Long id) {
        logger.info("Finding one user!");

        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    public Users update(Users user) {

        logger.info("Updating one user!");

        Users entity = repository.findById(user.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setLogin(user.getLogin());
        entity.setPassword(user.getPassword());
        entity.setUser_id(user.getUser_id());
        entity.setRole(user.getRole());

        return repository.save(user);
    }

    public void delete(Long id) {

        logger.info("Deleting one user!");

        Users entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        repository.delete(entity);
    }

    public Users create(Users user) {

        logger.info("Creating one user!");

        return repository.save(user);
    }
}
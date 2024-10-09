package br.com.smartcondo.services;

import br.com.smartcondo.exceptions.ResourceNotFoundException;
import br.com.smartcondo.models.Correspondence;
import br.com.smartcondo.records.CorrespondenceDTO;
import br.com.smartcondo.repositories.CorrespondenceRepository;
import jakarta.transaction.Transactional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class CorrespondenceService {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(CorrespondenceService.class);
    private Logger logger = Logger.getLogger(CorrespondenceService.class.getName());

    @Autowired
    CorrespondenceRepository repository;


    public List<Correspondence> findAll(){
        logger.info("Finding all correspondence!");

        return repository.findAll();
    }

    public Correspondence findById(long id){
        logger.info("Finding one correspondence!");

        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    public List<Correspondence> findByIdUser(long id){
        logger.info("Finding one correspondence!");

        return repository.findByResident_id(id);
    }

    @Transactional
    public List<CorrespondenceDTO> findByIdCondominium(long id){
        logger.info("Finding all correspondence by condominium!");
        List<CorrespondenceDTO> correspondenceDTOList = new ArrayList<>();
        List<Correspondence> correspondenceList = repository.findByCondominium_id(id);
        for (Correspondence correspondence : correspondenceList){
            correspondenceDTOList.add(new CorrespondenceDTO(correspondence, correspondence.getResident()));
        }
        return correspondenceDTOList;
    }

    public Correspondence update(Correspondence correspondence){
        logger.info("Updating one correspondence!");

        Correspondence entity = repository.findById(correspondence.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setDate(correspondence.getDate());
        entity.setHours(correspondence.getHours());
        entity.setSender(correspondence.getSender());

        return repository.save(correspondence);
    }

    public Correspondence create(Correspondence correspondence){
        logger.info("Creating one correspondence!");

        return repository.save(correspondence);
    }

    public void delete(Long id){
        logger.info("Deleting one correspondence!");

        Correspondence correspondence = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        repository.delete(correspondence);
    }
}

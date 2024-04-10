package br.com.smartcondo.services;

import br.com.smartcondo.exceptions.ResourceNotFoundException;
import br.com.smartcondo.models.Kiosk;
import br.com.smartcondo.repositories.KioskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class KioskService {

    Logger logger = Logger.getLogger(KioskService.class.getName());

    @Autowired
    KioskRepository kioskRepository;

    public List<Kiosk> findAll() {
        logger.info("Finding all kiosk!");

        return kioskRepository.findAll();
    }

    public Kiosk findById(Long id) {
        logger.info("Finding one kiosk!");

        return kioskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));
    }

    public List<Kiosk> findByIdCondominium(Long id){
        logger.info("Finding all kiosks this condominium");

        return kioskRepository.findByCondominium_id(id);
    }

    public Kiosk update(Kiosk kiosk) {
        logger.info("Updating one kiosk!");

        Kiosk entity = kioskRepository.findById(kiosk.getId()).orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));

        entity.setDescription(kiosk.getDescription());
        entity.setType(kiosk.getType());

        return kioskRepository.save(kiosk);
    }

    public void delete(Long id){
        logger.info("Deleting one kiosk!");

        Kiosk entity = kioskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No record found for this ID"));

        kioskRepository.delete(entity);
    }

    public Kiosk create(Kiosk kiosk){
        logger.info("Creating one kiosk!");

        return kioskRepository.save(kiosk);
    }
}

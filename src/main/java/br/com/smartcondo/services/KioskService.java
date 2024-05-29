package br.com.smartcondo.services;

import br.com.smartcondo.exceptions.ResourceNotFoundException;
import br.com.smartcondo.models.Kiosk;
import br.com.smartcondo.models.Resident;
import br.com.smartcondo.records.ReservationAndKioskDTO;
import br.com.smartcondo.repositories.KioskRepository;
import br.com.smartcondo.repositories.ReservationRepository;
import br.com.smartcondo.repositories.ResidentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class KioskService {

    Logger logger = Logger.getLogger(KioskService.class.getName());

    @Autowired
    ResidentRepository residentRepository;

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

    public List<Kiosk> findByIdResident(Long id){
        logger.info("Finding all kiosks this resident");

        Resident resident = residentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No record found for this ID"));

        return findByIdCondominium(resident.getCondominium().getId());
    }

    @Transactional
    public List<ReservationAndKioskDTO> findAllDetails(Long id) {
        logger.info("Finding all kiosk details!");
        List<Kiosk> kiosks = findByIdResident(id);
        List<ReservationAndKioskDTO> reservationAndKioskDTOS = new ArrayList<>();
        for (Kiosk kiosk : kiosks){
            System.out.println(kiosk.getReservations());
            reservationAndKioskDTOS.add(new ReservationAndKioskDTO(kiosk.getReservations(), kiosk));
        }
        return reservationAndKioskDTOS;
    }
}

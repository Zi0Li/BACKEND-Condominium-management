package br.com.smartcondo.services;

import br.com.smartcondo.exceptions.ResourceNotFoundException;
import br.com.smartcondo.models.Reservation;
import br.com.smartcondo.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ReservationService {

    Logger logger = Logger.getLogger(ResidentService.class.getName());

    @Autowired
    ReservationRepository reservationRepository;

    public List<Reservation> findAll(){
        logger.info("Finding all reservations!");

        return reservationRepository.findAll();
    }

    public Reservation findById(Long id){
        logger.info("Finding one reservation!");

        return reservationRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
    }

    public Reservation update(Reservation reservation){
        logger.info("Updating one reservation");

        Reservation entity = reservationRepository.findById(reservation.getId()).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));

        entity.setDate(reservation.getDate());
        entity.setDescription(reservation.getDescription());

        return reservationRepository.save(reservation);
    }

    public void delete(Long id){
        logger.info("Deleting one reservation!");

        Reservation entity = reservationRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));

        reservationRepository.delete(entity);
    }

    public Reservation create(Reservation reservation){
        logger.info("Creating one reservation!");

        return reservationRepository.save(reservation);
    }
}

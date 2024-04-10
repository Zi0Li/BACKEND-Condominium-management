package br.com.smartcondo.services;

import br.com.smartcondo.exceptions.ResourceNotFoundException;
import br.com.smartcondo.models.Notification;
import br.com.smartcondo.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class NotificationService {
    private Logger logger = Logger.getLogger(NotificationService.class.getName());

    @Autowired
    NotificationRepository notificationRepository;

    public List<Notification> findAll(){
        logger.info("Finding all notification!");

        return notificationRepository.findAll();
    }

    public Notification findById(Long id){
        logger.info("Finding one notification!");

        return notificationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    public List<Notification> findByIdCondominium(Long id){
        logger.info("Finding all notification this condominium");

        return notificationRepository.findByCondominium_id(id);
    }

    public Notification update(Notification notification){
        logger.info("Updating one notification!");

        Notification entity = notificationRepository.findById(notification.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setCategory(notification.getCategory());
        entity.setDescription(notification.getDescription());
        entity.setType(notification.getType());

        return notificationRepository.save(notification);
    }

    public void delete(Long id){
        logger.info("Deleting on notification!");

        Notification entity = notificationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        notificationRepository.delete(entity);
    }

    public Notification create(Notification notification){
        logger.info("Creating one notification");

        return notificationRepository.save(notification);
    }

}
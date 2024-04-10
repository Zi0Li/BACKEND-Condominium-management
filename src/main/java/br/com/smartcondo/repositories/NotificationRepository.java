package br.com.smartcondo.repositories;

import br.com.smartcondo.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByCondominium_id(Long id);
}

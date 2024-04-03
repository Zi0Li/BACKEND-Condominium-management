package br.com.smartcondo.repositories;

import br.com.smartcondo.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}

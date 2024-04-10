package br.com.smartcondo.repositories;

import br.com.smartcondo.models.Kiosk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KioskRepository extends JpaRepository<Kiosk, Long> {

    List<Kiosk> findByCondominium_id(Long id);
}

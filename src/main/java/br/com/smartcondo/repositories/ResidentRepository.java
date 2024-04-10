package br.com.smartcondo.repositories;

import br.com.smartcondo.models.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ResidentRepository extends JpaRepository<Resident, Long> {

    List<Resident> findByCondominium_id(Long id);
}

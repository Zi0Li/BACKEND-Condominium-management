package br.com.smartcondo.repositories;

import br.com.smartcondo.models.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ResidentRepository extends JpaRepository<Resident, Long> {}

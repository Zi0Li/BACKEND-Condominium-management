package br.com.smartcondo.repositories;

import br.com.smartcondo.models.Condominium;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CondominiumRepository extends JpaRepository<Condominium, Long> {
}

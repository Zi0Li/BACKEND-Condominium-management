package br.com.smartcondo.repositories;

import br.com.smartcondo.models.Condominium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CondominiumRepository extends JpaRepository<Condominium, Long> {
    Optional<Condominium> findByCode(int code);
}
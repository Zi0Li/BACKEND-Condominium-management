package br.com.smartcondo.repositories;

import br.com.smartcondo.models.CondominiumAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CondominiumAddressRepository extends JpaRepository<CondominiumAddress, Long> {
}

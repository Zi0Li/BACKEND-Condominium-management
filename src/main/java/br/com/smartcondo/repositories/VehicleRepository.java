package br.com.smartcondo.repositories;

import br.com.smartcondo.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Optional<List<Vehicle>> findByResident_id(long id);
}
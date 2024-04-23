package br.com.smartcondo.repositories;

import br.com.smartcondo.models.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Long> {

    List<Employees> findByCondominium_id(Long id);
}

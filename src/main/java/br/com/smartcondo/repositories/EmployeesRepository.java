package br.com.smartcondo.repositories;

import br.com.smartcondo.models.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employees, Long> {
}

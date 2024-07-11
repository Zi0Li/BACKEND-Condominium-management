package br.com.smartcondo.repositories;

import br.com.smartcondo.models.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

    List<Report> findByCondominium_id(Long id);

    List<Report> findByResident_id(Long id);
}

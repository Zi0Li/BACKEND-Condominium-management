package br.com.smartcondo.services;

import br.com.smartcondo.exceptions.ResourceNotFoundException;
import br.com.smartcondo.models.Report;
import br.com.smartcondo.records.ReportDTO;
import br.com.smartcondo.repositories.ReportRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class ReportService {
    private Logger logger = Logger.getLogger(ReportService.class.getName());

    @Autowired
    ReportRepository repository;

    public List<Report> findAll() {
        logger.info("Finding all reports!");
        return repository.findAll();
    }

    public Report findById(Long id) {
        logger.info("Finding one report!");
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    @Transactional
    public List<ReportDTO> findByIdCondominium(Long id) {
        logger.info("Finding all report this condominium_id");

        List<Report> reports = repository.findByCondominium_id(id);
        List<ReportDTO> reportDTOList = new ArrayList<>();
        for (Report report : reports) {
            reportDTOList.add(new ReportDTO(report, report.getResident()));
        }

        return reportDTOList;
    }

    public List<Report> findByIdResident(Long id) {
        logger.info("Finding all report this resident_id");

        return repository.findByResident_id(id);
    }

    public Report update(Report report) {
        logger.info("Updating one report!");

        Report entity = repository.findById(report.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setDate(report.getDate());
        entity.setDescription(report.getDescription());
        entity.setType(report.getType());
        entity.setStatus(report.getStatus());
        entity.setTitle(report.getTitle());
        entity.setResident(report.getResident());
        entity.setView(report.getView());

        return repository.save(report);
    }

    public void delete(Long id) {
        logger.info("Deleting one report");

        Report entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        repository.delete(entity);

    }

    public Report create(Report report) {
        logger.info("Creating one report!");
        return repository.save(report);
    }
}

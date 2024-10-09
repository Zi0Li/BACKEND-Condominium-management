package br.com.smartcondo.repositories;

import br.com.smartcondo.models.Correspondence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CorrespondenceRepository extends JpaRepository<Correspondence, Long> {

    List<Correspondence> findByCondominium_id(Long id);

    List<Correspondence> findByResident_id(Long id);
}

package br.com.smartcondo.repositories;

import br.com.smartcondo.models.Rule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RuleRepository extends JpaRepository<Rule, Long> {

    List<Rule> findByCondominium_id(Long id);
}

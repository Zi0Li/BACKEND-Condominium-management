package br.com.smartcondo.repositories;

import br.com.smartcondo.models.Syndicate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SyndicateRepository extends JpaRepository<Syndicate, Long> {
}

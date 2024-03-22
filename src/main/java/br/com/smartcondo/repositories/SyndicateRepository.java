package br.com.smartcondo.repositories;

import br.com.smartcondo.models.Syndicate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SyndicateRepository extends JpaRepository<Syndicate, Long> {
}

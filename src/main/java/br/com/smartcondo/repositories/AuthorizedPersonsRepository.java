package br.com.smartcondo.repositories;

import br.com.smartcondo.models.AuthorizedPersons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorizedPersonsRepository extends JpaRepository<AuthorizedPersons, Long> {
}

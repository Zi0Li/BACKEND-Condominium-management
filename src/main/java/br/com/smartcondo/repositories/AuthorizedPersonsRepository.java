package br.com.smartcondo.repositories;

import br.com.smartcondo.models.AuthorizedPersons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorizedPersonsRepository extends JpaRepository<AuthorizedPersons, Long> {
    Optional<List<AuthorizedPersons>> findByResident_id(int id);

    Optional<AuthorizedPersons> findByCpfOrRg(String cpf, String rg);
}

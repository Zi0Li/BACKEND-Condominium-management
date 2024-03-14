package br.com.smartcondo.repositories;

import br.com.smartcondo.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}

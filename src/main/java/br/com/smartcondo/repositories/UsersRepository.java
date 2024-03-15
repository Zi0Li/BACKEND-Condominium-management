package br.com.smartcondo.repositories;

import br.com.smartcondo.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByLogin(String login);
}

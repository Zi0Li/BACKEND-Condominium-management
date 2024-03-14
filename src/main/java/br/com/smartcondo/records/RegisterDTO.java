package br.com.smartcondo.records;

import br.com.smartcondo.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role, Long user_id) {
}

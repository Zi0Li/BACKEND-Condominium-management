package br.com.smartcondo.records;

import br.com.smartcondo.enums.UserRole;

public record LoginResponseDTO(String token, String role, Object entity) {
}

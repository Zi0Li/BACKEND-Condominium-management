package br.com.smartcondo.records;

public record LoginResponseDTO(String token, String role, Object entity) {
}

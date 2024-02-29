package com.example.cardapio.domain.user;

public record RegisterDTO(String login, String password, UserRole role) {
}

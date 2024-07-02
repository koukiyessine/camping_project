package com.example.camping.project.dto;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.example.camping.project.Entities.User;


public record AuthenticationUserDTO(
        int id_user,
        String login,
        List<String> roles) {
    public static AuthenticationUserDTO toAuthenticationUserDTO(User user) {
        List<String> roles = user.getRole().getAuthorities()
                .stream()
                .map(SimpleGrantedAuthority::getAuthority)
                .toList();
        return new AuthenticationUserDTO(user.getId_user(), user.getLogin(), roles);
    }
}

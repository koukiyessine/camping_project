package com.example.camping.project.dto;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.camping.project.Entities.User;
import com.example.camping.project.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegisterUserDTO(
        @NotBlank(message = "firstname is required") String nom,
        @NotBlank(message = "lastname is required") String prenom,
        @NotBlank(message = "email is required") @Email(message = "email format is not valid") String login,
        @NotBlank(message = "password is required")  @Size(min = 6, message = "Password must be at most 6 characters long") String password,
        @NotNull Role role) {
  
            public static User fromRegisterUserDTO(RegisterUserDTO registerUserDTO, PasswordEncoder passwordEncoder) {
        User user = User.builder()
                .nom(registerUserDTO.nom())
                .prenom(registerUserDTO.prenom())
                .login(registerUserDTO.login())
                .password(passwordEncoder.encode(registerUserDTO.password()))
                .role(registerUserDTO.role())
                .build();
        return user;
    }

    public static RegisterUserDTO toRegisterUserDTO(User user) {
        return new RegisterUserDTO(user.getNom(),
                user.getPrenom(),
                user.getLogin(),
                user.getPassword(),
                user.getRole());
    }
}


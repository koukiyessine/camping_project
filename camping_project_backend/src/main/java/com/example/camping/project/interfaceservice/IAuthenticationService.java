package com.example.camping.project.interfaceservice;

import org.springframework.security.core.Authentication;
import com.example.camping.project.Entities.User;
import com.example.camping.project.dto.AuthenticationUserDTO;
import com.example.camping.project.exception.DuplicateUserException;

public interface IAuthenticationService {

        User register(User user) throws DuplicateUserException;
   AuthenticationUserDTO login(Authentication authentication);
    
}
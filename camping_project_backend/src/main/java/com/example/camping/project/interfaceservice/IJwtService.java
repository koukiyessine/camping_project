package com.example.camping.project.interfaceservice;


import org.springframework.http.ResponseCookie;
import org.springframework.security.core.Authentication;

public interface IJwtService {
    String generateToken(Authentication authentication);
    ResponseCookie generateJwtCookie(String jwt);
    ResponseCookie getCleanJwtCookie();
}
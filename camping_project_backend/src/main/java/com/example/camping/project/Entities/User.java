package com.example.camping.project.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> listReservation;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user;

    @Column(nullable = false, unique = false)
    @Size(min = 5, max = 20)
    private String nom;

    @Column(nullable = false, unique = false)
    @Size(min = 5, max = 20)
    private String prenom;

    @Column(nullable = false, unique = true)
    @Email(message = "Invalid email format")
    @Pattern(regexp = "[A-Za-z0-9!@#$%^&*()_+{}|:;'<>?.,~-]+")
    private String login;

    @Column(nullable = false, unique = true)
    @Pattern(regexp = "[A-Za-z0-9!@#$%^&*()_+{}|:;'<>?.,~-]+")
    private String password;

    @Pattern(regexp = "[A-Za-z0-9!@#$%^&*()_+{}|:;'<>?.,~-]+")
    private String confpassword;


}

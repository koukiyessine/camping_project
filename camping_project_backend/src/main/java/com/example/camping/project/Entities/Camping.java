package com.example.camping.project.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Camping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id_camping;
    @Column(nullable = false, unique = true)
    @Size(min = 5, max = 200)
    private String nom;
    @Column(nullable = false, unique = true)
    @Size(min = 5, max = 200)
    private String adresse;
    @Column(nullable = false, unique = true)
    @Size(min = 5, max = 200)
    private String description;
    
    @Column(nullable = false, unique = true)
    @Size(min = 5, max = 200)
    private String budget;
    
    @Column(nullable = false, unique = true)
    @Max(45)
    @NotNull
    private int age;

    @Column(nullable = false, unique = true)
    @Size(min = 5, max = 200)
    private String status;
    
}
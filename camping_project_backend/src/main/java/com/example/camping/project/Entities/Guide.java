package com.example.camping.project.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Guide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Guide;

    @Column(nullable = false, unique = true)
    @Size(min = 5, max = 10)
    private String nom;
    @Column(nullable = false, unique = true)
    @Size(min = 5, max = 10)
    private String specialite;
    @Column(nullable = false, unique = true)
    @Size(min = 5, max = 10)
    private String ville;
}
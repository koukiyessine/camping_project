package com.example.camping.project.Entities;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Avis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_avis;
    
    @Column(nullable = false, unique = true)
    @Size(min = 5, max = 200)
    
    private String nom;
    @Column(nullable = false, unique = true)
    @Size(min = 5, max = 200)
    private String contenu;

    @Column(nullable = false, unique = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;
    
}
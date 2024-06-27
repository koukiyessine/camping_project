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

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Camping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCamping;

    @Column(nullable = false, unique = true)
    @Size(min = 5, max = 200)

    private String destination;

    @Column(nullable = false, unique = true)
    @Size(min = 5, max = 200)
    private String description;

    @Column(nullable = false, unique = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDebut;


    @Column(nullable = false, unique = true)
    @Size(min = 5, max = 200)
    private String status;

    private double prixCamping;

    @Column(nullable = false, unique = true)
    @Size(min = 5, max = 200)
    private String season;

}

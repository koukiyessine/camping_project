package com.example.camping.project.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Reservation {

    @ManyToOne
    private User user;

    @ManyToOne
    private Camping camping;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_reservation;

    @Column(nullable = false, unique = true)
    @Size(min = 5, max = 200)
    private String budget;

    @Column(nullable = false, unique = true)
    @Max(45)
    @NotNull
    private int age;

}
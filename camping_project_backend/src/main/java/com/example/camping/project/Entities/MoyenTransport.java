package com.example.camping.project.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class MoyenTransport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_moyentransp;

    @Column(nullable = false, unique = true)
    private String type;

    @Column(nullable = false, unique = true)
    private int capacite;

}
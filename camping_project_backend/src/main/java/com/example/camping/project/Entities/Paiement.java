package com.example.camping.project.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Paiement {


    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_paiement;

    @NotNull
    private long prix_unitaire;
    @NotNull
    private long total;

    
}
package com.example.camping.project.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Paiement {

    @ManyToOne
    @JoinColumn(name = "id_reservation")
    private Reservation reservation;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_paiement;

    @NotNull
    private long total;
}

package com.example.camping.project.Entities;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Reservation {

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Camping> listCamping;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_reservation;

    @Column(nullable = false)
    @Size(min = 5, max = 200)
    private String budget;

    @Column(nullable = false)
    @Max(45)
    @NotNull
    private int age;
}

package com.example.camping.project.Entities;

import java.sql.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    
    @OneToMany
    private List<MoyenTransport> listMoyenTransport;

    @ManyToOne
    private User user;

    @OneToMany
    private List<Reservation> listReservation;

    @OneToMany
    private List<Activite> listActivite;

    @OneToMany
    private List<Guide> listGuide;

    @OneToMany
    private List<Avis> listAvis;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_camping;

    @Column(nullable = false, unique = true)
    @Size(min = 5, max = 200)

    private String destination;
    @Column(nullable = false, unique = true)
    @Size(min = 5, max = 2000)

    private String description;
    @Column(nullable = false, unique = true)
    private String prixCamping;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date dateDebut;
    @Column(nullable = false, unique = true)
    @Size(min = 5, max = 40)

    private String status;
    @Column(nullable = false)
    @Size(min = 5, max = 40)
    private String season;

}
package com.example.camping.project.Entities;

import java.sql.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

    @OneToMany(mappedBy = "camping", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> listReservation;

    @OneToMany(mappedBy = "camping", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Activite> listActivite;

    @OneToMany(mappedBy = "camping", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Avis> listAvis;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @OneToMany(mappedBy = "camping", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Guide> listGuide;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_camping;

    @Column(nullable = false, unique = false)
    @Size(min = 3, max = 200)
    private String destination;

    @Column(nullable = false, unique = false)
    @Size(min = 3, max = 2000)
    private String description;

    @Column(nullable = false, unique = false)
    private String prixCamping;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDebut;

    @Column(nullable = false, unique = false)
    @Size(min = 5, max = 40)
    private String status;

    @Column(nullable = false)
    @Size(min = 3, max = 40)
    private String season;
}

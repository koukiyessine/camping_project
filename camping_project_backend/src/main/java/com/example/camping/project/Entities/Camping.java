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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Camping {

    @ManyToOne
    @JoinColumn(name = "id_guide")
    private Guide guide;

    @ManyToOne
    @JoinColumn(name = "id_Avis")
    private Avis avis;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @OneToMany(mappedBy = "camping", cascade = CascadeType.ALL, orphanRemoval = true)
       @JsonIgnore
    private List<Reservation> listreservation;

    @ManyToOne
    @JoinColumn(name = "id_activite")
    private Activite activite;

    @ManyToOne
    @JoinColumn(name = "id_mtrans")
    private MoyenTransport moyenTransport;

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

package com.example.camping.project.Entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class MoyenTransport {

 @OneToMany(mappedBy = "moyenTransport", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Camping> listCamping;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_moyentransp;

    @Column(nullable = false, unique = true)
    private String type;

    @Column(nullable = false, unique = true)
    private int capacite;

}
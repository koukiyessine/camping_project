package com.example.camping.project.Entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Guide {

    @OneToMany(mappedBy = "guide", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Camping> listCamping;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Guide;

    @Size(min = 2, max = 10)
    private String nom;

    @Size(min = 2, max = 40)
    private String specialite;

    @Size(min = 3, max = 10)
    private String ville;

    private long prix_guide;
}

package com.example.camping.project.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Guide {


  @ManyToOne
  @JoinColumn(name = "id_camping")
  private Camping camping;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Guide;

    @Size(min = 2, max = 10)
    private String nom;

    @Size(min = 2, max = 40)
    private String specialite;

    @Size(min = 3, max = 10)
    private String ville;
          
    private long prix_guide ;

}
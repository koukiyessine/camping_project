package com.example.camping.project.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
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
public class Activite {

  @ManyToOne
  @JoinColumn(name = "id_camping")
  private Camping camping;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private int id_activite;
  @Column(nullable = false, unique = false)
  @Size(min = 5, max = 20)
  private String nom;
  @Column(nullable = false, unique=false)
  @NotEmpty
  private String description;
  @Column(nullable = false, unique = false)
  @NotEmpty
  private String type;

  @Column(nullable = false, unique = false)
  private String photo;

  @Column(nullable = false, unique = false)
  private long prix_activite;
}
package com.example.camping.project.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Destinations{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id_destinations;
    @Column(nullable = false, unique = true)
    @Size(min = 5, max = 20)
    @NotBlank
    private String ville;
    @Column(nullable = false, unique = true)
    @Size(min = 5, max = 20)
    @NotEmpty
    private String type;
    @Column(nullable = false, unique = true)
    @NotNull
    @Max(5000)
    private int capacite;

    
}
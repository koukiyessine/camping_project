package com.example.camping.project.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
/* import jakarta.validation.constraints.NotNull;
 */import jakarta.validation.constraints.Size;
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
public class Activite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id_activite;
    @Column(nullable = false, unique = true)
    @Size(min = 5, max = 20)
    private String nom;
    @Column(nullable = false, unique = true)
    @NotEmpty
    private String description;
    @Column(nullable = false, unique = true)
    @NotEmpty
    private String type;

    @Column(nullable = false, unique = true)
  /*   @NotEmpty(message = "Please choose a photo")
    @NotNull(message = "Photo cannot be null") */
    private String photo;
}
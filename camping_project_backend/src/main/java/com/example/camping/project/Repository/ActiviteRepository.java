package com.example.camping.project.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.camping.project.Entities.Activite;

@Repository
public interface ActiviteRepository extends CrudRepository<Activite, Integer>{

    List<Activite> findBynom(String ch);

    List<Activite> findBynomStartingWith(String ch);


/*     Activite getActiviteByid_activite(int id); */

}
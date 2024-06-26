package com.example.camping.project.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.camping.project.Entities.Paiement;

@Repository
public interface PaiementRepository extends CrudRepository<Paiement, Integer>{   
        
}
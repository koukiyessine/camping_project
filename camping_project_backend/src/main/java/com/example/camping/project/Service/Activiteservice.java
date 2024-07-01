package com.example.camping.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.camping.project.Entities.Activite;
import com.example.camping.project.Repository.ActiviteRepository;
import com.example.camping.project.Repository.CampingRepository;
import com.example.camping.project.interfaceservice.IActiviteservice;
import jakarta.transaction.Transactional;

@Service
public class Activiteservice implements IActiviteservice{
    
    @Autowired
    ActiviteRepository actrep;

        @Autowired
    CampingRepository camprepo;
  

    private final FilesStorageService filesStorageService;

    public Activiteservice ( FilesStorageService filesStorageService) {
        this.filesStorageService = filesStorageService;
    }
    @Override
    public  Activite addActivite(Activite A) {
        return actrep.save(A);
    }


        @Override
        public Activite updateActivite(Activite activ, int id_activite) {
              
            Activite ac=actrep.findById(id_activite).get();

            ac.setNom(activ.getNom());
            ac.setDescription(activ.getDescription());
            ac.setType(activ.getType());
            ac.setPhoto(activ.getPhoto());

            actrep.save(ac);
            return ac;
        }


    @Override
    @Transactional
    // the deleteContact method executes all its operations (checking for the contact, deleting the file, 
    //and deleting the contact record) within a single transaction.If any part of this process fails, 
    //the entire transaction will be rolled back, maintaining data consistency and integrity. 
    public void deleteActivite(int id) {
        // Check if the ID is null and throw an IllegalArgumentException if it is
        if (id == 0) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        try {
            // Retrieve the contact by ID
            Activite activite =actrep.findById(id).get();
            // Get the image filename associated with the contact
            String filename = activite.getPhoto();
            // If the contact has an image, delete it
            if (filename != null) {
                filesStorageService.delete(filename);
            }
            // Delete the contact from the repository by ID
            actrep.deleteById(id);
        } catch (DataAccessException e) {
            // Capture any data access exceptions (e.g., foreign key constraint violations)
            throw new RuntimeException("Failed to delete contact with id: " + id, e);
        }
    }

        
            @Override
    public String  getallActivitebynom(String ch) {
        StringBuilder ch1 = new StringBuilder();  // Initialisation de StringBuilder
        List<Activite> Activites = actrep.findBynomStartingWith(ch);  // Trouver les campings dont la destination commence par `ch`
        
        for (Activite  activite : Activites) {
        ch1.append(activite.getNom()).append(": ");  // Concaténer chaque destination séparée par une virgule et un espace
        ch1.append(activite.getPrix_activite()).append("$"+"\n");  // Concaténer chaque destination séparée par une virgule et un espace
  
    }
    
    
        return ch1.toString();  // Retourner la chaîne de caractères
    }

        @Override
        public List<Activite> getallActivite() {
            return (List<Activite>) actrep.findAll();
        }


/*         @Override
        public List<Activite> getallActivitebynom(String ch) {

            return actrep.findBynom(ch);
        } */



    @Override
    public int getnombreActivitedispo() {
            return (int) actrep.count() ;
    }
            
            


    @Override
    public Activite updateActiviteImage(int id, String filename) {
        // Check if the ID is null and throw an IllegalArgumentException if it is
        if (id == 0) {
            throw new IllegalArgumentException("ID cannot be null");
        }
      
        // Retrieve the activite by ID, throw an EntityNotFoundException if the activite
        // is not found
        Activite activite = actrep.findById(id).get();

        // Check if the activite already has an image
        if (activite.getPhoto() == null) {
            // If the activite does not have an image, set the new image
            activite.setPhoto(filename);
        } else {
            // If the activite already has an image, delete the old image
            this.filesStorageService.delete(activite.getPhoto());
            // Set the new image
            activite.setPhoto(filename) ;        }
        // Save and return the updated activite in the repository
        return actrep.save(activite);
    }


}
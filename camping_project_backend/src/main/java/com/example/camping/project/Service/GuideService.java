package com.example.camping.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.camping.project.Entities.Guide;
import com.example.camping.project.Repository.GuideRepository;
import com.example.camping.project.interfaceservice.IGuideService;

@Service
public class GuideService implements IGuideService {

    @Autowired
    GuideRepository guiderepo;



    @Override
    public Guide addGuide(Guide g ) {
        return guiderepo.save(g);
    }

    @Override
    public List<Guide> getallGuide() {
        return (List<Guide>) guiderepo.findAll();
    }

/*     @Override
    public List<Guide> getallGuidebynomGuide(String ch) {
        return guiderepo.findBynomStartingWith(ch);
    } */

    @Override
    public Guide updateGuide(Guide guide, int id_Guide) {

        Guide gud = guiderepo.findById(id_Guide).get();

        if (id_Guide == 0) {
            throw new IllegalArgumentException("value cannot be null !");
        }else{
        gud.setNom(guide.getNom());
        gud.setSpecialite(guide.getSpecialite());
        gud.setVille(guide.getVille());
        
        guiderepo.save(gud);
        }
        return gud;

    }


         @Override
    public String getallGuidebynomGuide(String ch) {
        StringBuilder ch1 = new StringBuilder();  // Initialisation de StringBuilder
        List<Guide> guides = guiderepo.findBynomStartingWith(ch);  // Trouver les campings dont la destination commence par `ch`
        
        for (Guide guide : guides) {
        ch1.append(guide.getNom()).append(": ").append(guide.getSpecialite()+"\n");  // Concaténer chaque destination séparée par une virgule et un espace
        }
    
    
        return ch1.toString();  // Retourner la chaîne de caractères
    }

    @Override
    public int getnombreGuidedispo(){
       return (int) guiderepo.count();
    }
}
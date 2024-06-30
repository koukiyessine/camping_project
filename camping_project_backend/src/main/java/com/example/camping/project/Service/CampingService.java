package com.example.camping.project.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.camping.project.Entities.Activite;
import com.example.camping.project.Entities.Avis;
import com.example.camping.project.Entities.Camping;
import com.example.camping.project.Entities.Guide;
import com.example.camping.project.Entities.MoyenTransport;
import com.example.camping.project.Entities.Reservation;
import com.example.camping.project.Entities.User;
import com.example.camping.project.Repository.ActiviteRepository;
import com.example.camping.project.Repository.AvisRepository;
import com.example.camping.project.Repository.CampingRepository;
import com.example.camping.project.Repository.GuideRepository;
import com.example.camping.project.Repository.MoyenTransportRepository;
import com.example.camping.project.Repository.ReservationRepository;
import com.example.camping.project.Repository.UserRepository;
import com.example.camping.project.interfaceservice.ICampingService;

@Service
public class CampingService implements ICampingService {

    @Autowired
    CampingRepository camprepo;

    @Autowired
    AvisRepository avisrepo;

    @Autowired
    UserRepository userep;

        @Autowired
    ReservationRepository reservrepo;

        @Autowired
    GuideRepository guiderepo;

        @Autowired
    MoyenTransportRepository moyentransrep;

        
    @Autowired
    ActiviteRepository actrep;

    @Override
    public Camping addCamping(Camping c,int id_Avis ,int id_guide,int id_activite,
    int id_mtrans,int id_user) {

    Guide guide = guiderepo.findById(id_guide).get();
    MoyenTransport moyenTransport = moyentransrep.findById(id_mtrans).get();
    Activite activite = actrep.findById(id_activite).get();
    User user = userep.findById(id_user).get() ;
    Avis avis = avisrepo.findById(id_Avis).get() ;

    
    c.setActivite(activite);
    c.setAvis(avis);
    c.setGuide(guide);
    c.setActivite(activite);
    c.setMoyenTransport(moyenTransport);
    c.setUser(user);
        return camprepo.save(c);
    }

    @Override
    public List<Camping> getallCamping() {
        return (List<Camping>) camprepo.findAll();
    }

    @Override
    public String getAllCampingByDestination(String ch) {
        StringBuilder ch1 = new StringBuilder();  // Initialisation de StringBuilder
        List<Camping> campings = camprepo.findBydestinationStartingWith(ch);  // Trouver les campings dont la destination commence par `ch`
        
        for (Camping camping : campings) {
        ch1.append(camping.getDestination()).append("\n");  // Concaténer chaque destination séparée par une virgule et un espace
        }
    
    
        return ch1.toString();  // Retourner la chaîne de caractères
    }
    

    @Override
    public void deleteCamping(Camping c) {
        camprepo.delete(c);
    }

    @Override
    public int getnombreCampingdispo(){
       return (int) camprepo.count();
    }

}
package com.example.camping.project.Service;

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
    public Camping addCamping(Camping c,int id_Avis ,int id_guide,int id_reservation,int id_activite,
    int id_mtrans,int id_user) {

    Reservation reservation = reservrepo.findById(id_reservation).get();
    Guide guide = guiderepo.findById(id_guide).get();
    MoyenTransport moyenTransport = moyentransrep.findById(id_mtrans).get();
    Activite activite = actrep.findById(id_activite).get();
    User user = userep.findById(id_user).get() ;
    Avis avis = avisrepo.findById(id_Avis).get() ;


    c.setActivite(activite);
    c.setAvis(avis);
    c.setGuide(guide);
    c.setReservation(reservation);
    c.setActivite(activite);
    c.setMoyenTransport(moyenTransport);

        return camprepo.save(c);
    }

    @Override
    public List<Camping> getallCamping() {
        return (List<Camping>) camprepo.findAll();
    }

    @Override
    public List<Camping> getallCampingbydestination(String ch) {
        return camprepo.findBydestinationStartingWith(ch);
    }

    @Override
    public void deleteCamping(Camping c) {
        camprepo.delete(c);
    }
}
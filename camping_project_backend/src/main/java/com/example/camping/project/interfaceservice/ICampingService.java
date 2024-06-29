package com.example.camping.project.interfaceservice;

import java.util.List;

import com.example.camping.project.Entities.Camping;

public interface ICampingService {

        public Camping addCamping(Camping c,int id_Avis ,int id_guide,int id_reservation,int id_activite,
        int id_mtrans,int id_user);
        public List<Camping> getallCamping();

        public void deleteCamping(Camping c);

        public List<Camping> getallCampingbydestination(String ch);



}
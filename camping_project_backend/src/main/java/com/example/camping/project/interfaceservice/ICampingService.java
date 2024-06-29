package com.example.camping.project.interfaceservice;

import java.util.List;

import com.example.camping.project.Entities.Camping;

public interface ICampingService {

        public Camping addCamping(Camping c);

        public List<Camping> getallCamping();

        public void deleteCamping(Camping c);

        public List<Camping> getallCampingbydestination(String ch);



}
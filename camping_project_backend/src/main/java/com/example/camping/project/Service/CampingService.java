package com.example.camping.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.camping.project.Entities.Camping;
import com.example.camping.project.Repository.CampingRepository;
import com.example.camping.project.interfaceservice.ICampingService;

@Service
public class CampingService implements ICampingService {

    @Autowired
    CampingRepository camprepo;

    @Override
    public Camping addCamping(Camping c) {
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
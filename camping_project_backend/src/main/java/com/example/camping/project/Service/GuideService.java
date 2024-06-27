package com.example.camping.project.Service;

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
    public Guide addGuide(Guide g) {
        return guiderepo.save(g);
    }
    
}
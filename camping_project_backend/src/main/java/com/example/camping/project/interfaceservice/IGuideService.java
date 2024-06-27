package com.example.camping.project.interfaceservice;

import java.util.List;

import com.example.camping.project.Entities.Guide;

public interface IGuideService {

    public Guide addGuide(Guide g);

    public List<Guide> getallGuide();

    public List<Guide> getallGuidebynomGuide(String ch);
    
    public Guide updateGuide(Guide guide, int id_Guide);

}
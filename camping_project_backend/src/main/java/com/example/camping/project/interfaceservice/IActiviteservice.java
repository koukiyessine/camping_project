package com.example.camping.project.interfaceservice;


import java.util.List;

import com.example.camping.project.Entities.Activite;

public interface IActiviteservice {
    

   public  Activite addActivite(Activite A );
   public Activite updateActivite(Activite activ, int id_activite);
   public void deleteActivitefile(int id) ;
   public List <Activite> getallActivite();
   public List <Activite> getallActivitebynom(String ch);
   public Activite updateActiviteImage(int id, String filename) ;
   public void deleteActivite(Activite a); 

}
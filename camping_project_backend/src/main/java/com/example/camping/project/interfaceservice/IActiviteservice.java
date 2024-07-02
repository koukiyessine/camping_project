package com.example.camping.project.interfaceservice;


import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.camping.project.Entities.Activite;

import jakarta.annotation.Resource;

public interface IActiviteservice {
    

   public  Activite addActivite(Activite A );
   public Activite updateActivite(Activite activ, int id_activite);

   public List <Activite> getallActivite();
/*    public List <Activite> getallActivitebynom(String ch);
 */
public void deleteActivite(Activite actv) ;
   public int getnombreActivitedispo() ;
   public String  getallActivitebynom(String ch) ;
   public Activite updateActiviteImage(int id, MultipartFile file) ;
   public Resource loadFile(String filename) ;


}
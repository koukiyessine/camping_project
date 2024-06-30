package com.example.camping.project.interfaceservice;

import java.util.List;

import com.example.camping.project.Entities.Avis;

public interface IAvisservice {

        public Avis addavis(Avis a ) ;

        public List<Avis> getallavis();

        public void deleteAvis(Avis A);

        public Avis updateAvis(Avis Avis, int id_avis);
            
        public int getnombreAvisdispo() ;

}
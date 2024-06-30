package com.example.camping.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.camping.project.Entities.Avis;
import com.example.camping.project.Repository.AvisRepository;
import com.example.camping.project.Repository.CampingRepository;
import com.example.camping.project.interfaceservice.IAvisservice;
import java.util.List;

@Service
public class Avisservice implements IAvisservice {

    @Autowired
    AvisRepository avisrepo;

    @Autowired
    CampingRepository camprepo;

    @Override
    public Avis addavis(Avis a) {
     
        return avisrepo.save(a);
    }

    @Override
    public List<Avis> getallavis() {
        return (List<Avis>) avisrepo.findAll();
    }

    @Override
    public void deleteAvis(Avis A) {
        avisrepo.delete(A);
    }

    @Override
    public Avis updateAvis(Avis Avis, int id_avis) {

        Avis avs = avisrepo.findById(id_avis).get();

        avs.setContenu(Avis.getContenu());
        avs.setData(Avis.getData());
        avisrepo.save(avs);

        return avisrepo.save(avs);

    }
       
    @Override
    public int getnombreAvisdispo(){
       return (int) avisrepo.count();
    }
}
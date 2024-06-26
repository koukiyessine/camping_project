package com.example.camping.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.camping.project.Entities.Camping;
import com.example.camping.project.Repository.CampingRepository;
import com.example.camping.project.interfaceservice.ICampingService;

@Service
public class CampingService implements ICampingService  {

@Autowired
CampingRepository campRepo;

    @Override
    public Camping addCamping(Camping c) {
        return campRepo.save(c);
    }

    @Override
    public void deleteCamping(Camping c) {
        campRepo.delete(c);
    }

    
        @Override
    public Camping updateCamping(Camping camping, int id_camping) {
       
        Camping camp = campRepo.findById(id_camping).get();

        if(id_camping==0){
            System.out.println("cette id ni pas existe !");
        }else {
        camp.setNom(camp.getNom());
        camp.setStatus(camp.getStatus());
        camp.setDescription(camp.getDescription());
        camp.setAge(camp.getAge());
        camp.setBudget(camp.getBudget());
        campRepo.save(camp);
    }
        return camp;
    }


        @Override
    public List<Camping> getallCamping() {
        return (List<Camping>) campRepo.findAll();
    }

/*         @Override
    public List<Camping> getallCampingbybudget(String ch) {
        return campRepo.findBybudget(ch);
    } */

}

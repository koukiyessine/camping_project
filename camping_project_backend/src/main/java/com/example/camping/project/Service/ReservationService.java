package com.example.camping.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.camping.project.Entities.Camping;
import com.example.camping.project.Entities.Reservation;
import com.example.camping.project.Entities.User;
import com.example.camping.project.Repository.CampingRepository;
import com.example.camping.project.Repository.ReservationRepository;
import com.example.camping.project.Repository.UserRepository;
import com.example.camping.project.interfaceservice.IReservationService;

@Service
public class ReservationService implements IReservationService{
    
    @Autowired
    ReservationRepository reservrepo;

    @Autowired
    UserRepository userep;

    @Autowired
    CampingRepository camprepo;


    public Reservation addreservation(Reservation rsv , int id_user , int id_camping){
        
        User user=userep.findById(id_user).get();
        Camping camp=camprepo.findById(id_camping).get();
        
        rsv.setUser(user);
        rsv.setUser(user);
        rsv.setCamping(camp);
        rsv.setCamping(camp);
        rsv.setAge(rsv.getAge());
        rsv.setBudget(rsv.getBudget());

        return reservrepo.save(rsv) ;

    }



    public List<Reservation> getallreservation(Reservation reserv){
        return (List<Reservation>) reservrepo.findAll();
    }

    public int getnumdepersonnerservi(){
        return (int) reservrepo.count();
    }

      public void deleteReservation(Reservation reserv){
        reservrepo.delete(reserv);
      }

}
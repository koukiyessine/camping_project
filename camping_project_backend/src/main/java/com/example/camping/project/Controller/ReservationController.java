package com.example.camping.project.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.camping.project.Entities.Reservation;
import com.example.camping.project.Service.ReservationService;

@Controller
@RestController
public class ReservationController {
    
    @Autowired
    ReservationService reservserv;

        @PostMapping("/addreservation/{idu}/{idc}")
        public Reservation addreservation(@RequestBody Reservation rsv ,@PathVariable("idu") int id_user ,
        @PathVariable("idc") int id_camping){
            return reservserv.addreservation(rsv, id_user, id_camping) ;
        }

        @GetMapping("/getallreservation")
        public List<Reservation> getallreservation(Reservation reserv) {
         return reservserv.getallreservation(reserv) ;
        }


        @GetMapping("/getnumdepersonnerservi")
        public int getnumdepersonnerservi(){
            return reservserv.getnumdepersonnerservi();
        }

       
        @DeleteMapping("/deleteReservation")
       public void deleteReservation(Reservation reserv){
          reservserv.deleteReservation(reserv);
        }
 
    }
    

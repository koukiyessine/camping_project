package com.example.camping.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.camping.project.Entities.Camping;
import com.example.camping.project.Service.CampingService;

@Controller
@RestController
public class CampingController {
    
    @Autowired
    CampingService campserv;

        @PostMapping("/addCamping")
        public Camping addCamping(@RequestBody Camping c) {
         return campserv.addCamping(c) ;
        }
    
           @GetMapping("/getallCamping")
            public List<Camping> getallCamping() {
             return campserv.getallCamping();
            }

       @DeleteMapping("/deleteCamping/{c}")
            public void deleteCamping(@PathVariable Camping c) {
              campserv.deleteCamping(c);
            }

            @GetMapping("/getallCampingbydestination/{ch}")
            public List<Camping> getallCampingbydestination(@PathVariable String ch) {
               return campserv.getallCampingbydestination(ch) ;
            }


            @PostMapping("/addusercamping")
            public Camping addusercamping(@RequestBody Camping cp , @RequestParam("id") int id_user){
               return campserv.addusercamping(cp, id_user);
            }

    }


package com.example.camping.project.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.camping.project.Entities.Camping;
import com.example.camping.project.Service.CampingService;

@Controller
@RestController
public class CampingController {
       
    @Autowired
    CampingService campServ;
    
    @PostMapping("/addCamping")
    public Camping addCamping(Camping c) {
      return campServ.addCamping(c);
    }

    @DeleteMapping("/deletecamping/{id}")
    public void deleteCamping(@PathVariable("id") Camping c) {
       campServ.deleteCamping(c);
    }
    
   @PutMapping("/updateCamping")
    public Camping updateCamping(@RequestBody Camping camping, @PathVariable int id_camping) {
     return campServ.updateCamping(camping, id_camping);
    }

    @GetMapping("/getallCamping")
    public List<Camping> getallCamping() {
      return campServ.getallCamping() ;
    }
     
/*     @GetMapping("/getallCampingbynom/{ch}")
    public List<Camping> getallCampingbynom(@PathVariable String ch) {
         return campServ.getallCampingbynom(ch);
    } */
}
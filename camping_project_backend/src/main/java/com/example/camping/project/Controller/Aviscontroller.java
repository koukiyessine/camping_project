package com.example.camping.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.example.camping.project.Entities.Avis;
import com.example.camping.project.Service.Avisservice;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RestController
public class Aviscontroller {

  @Autowired
  Avisservice avisserv;

  @PostMapping("/addavis")
  public Avis addavis(@RequestBody Avis a) {
    return avisserv.addavis(a);
  }

  @GetMapping("/getallavis")
  public List<Avis> getallavis() {
    return (List<Avis>) avisserv.getallavis();
  }


  @DeleteMapping("/deleteAvis/{A}")
  public void deleteAvis(@PathVariable Avis A) {
     avisserv.deleteAvis(A);
  }


  @PutMapping("/updateAvis/{id_avis}")
  public Avis updateAvis(@RequestBody Avis Avis,@PathVariable int id_avis) {
   return avisserv.updateAvis(Avis, id_avis);
  }


  

}
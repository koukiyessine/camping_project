package com.example.camping.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.camping.project.Entities.Activite;
import com.example.camping.project.Service.Activiteservice;

import jakarta.validation.Valid;


@RestController
public class Activitecontroller {

  @Autowired
  Activiteservice actserv;

  @PostMapping("/addActivite")
  public Activite addActivite(@RequestBody Activite A) {
    return actserv.addActivite(A);
  }

  @PutMapping("/updateActivite/{id}")
  public Activite updateActivite(@Valid @RequestBody Activite activ, @PathVariable("id") int id_activite) {
    return actserv.updateActivite(activ, id_activite);
  }

  @DeleteMapping("/deleteActivite/{id}")
  public void deleteActivite(@PathVariable int id) {
    actserv.deleteActivite(id);
  }


  @GetMapping("/getallActivite")
  public List<Activite> getallActivite() {
    return actserv.getallActivite();
  }

  @GetMapping("/getallActivitebynom/{ch}")
  public String  getallActivitebynom(@PathVariable("ch") String ch) {

    return actserv.getallActivitebynom(ch);
  }

  @GetMapping("/getnombreActivitedispo")
  public int getnombreActivitedispo(){
   return actserv.getnombreActivitedispo() ;
}

}
package com.example.camping.project.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class Activitecontroller {

    @Autowired
    Activiteservice actserv;


/*        @PostMapping("/addActivite")
        public ResponseEntity<Activite> addActivite(@Valid @RequestBody Activite A) {
          Activite activ = actserv.addActivite(A);
          return new ResponseEntity<>(activ,HttpStatus.OK);
        }   */
        
        @PutMapping("/updateActivite/{id}")
        public Activite updateActivite(@Valid @RequestBody Activite activ,@PathVariable("id") int id_activite) {
          return actserv.updateActivite(activ, id_activite);
        }
       

/* 
        @DeleteMapping("/deleteActivite/{a}")
        public void deleteActivite(@PathVariable Activite a) {
            actserv.deleteActivite(a);
        } */

        @DeleteMapping("/deleteActivite/{id}")
        public void deleteActivite(@PathVariable int id){
        actserv.deleteActivite(id);
        }
            
        @GetMapping("/getallActivite")
        public List<Activite> getallActivite() {
        return actserv.getallActivite();
        }
           
        @GetMapping("/getallActivitebynom")
        public List<Activite> getallActivitebynom(@RequestParam String ch) {
              if(ch.isEmpty()){
                System.out.println("la variable de nom donneer est vide !");
              }

        return actserv.getallActivitebynom(ch);
        }
        

}
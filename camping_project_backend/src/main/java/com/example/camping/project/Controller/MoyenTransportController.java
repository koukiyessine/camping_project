package com.example.camping.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.camping.project.Entities.MoyenTransport;
import com.example.camping.project.Service.MoyenTransportService;

import jakarta.websocket.server.PathParam;

@Controller
@RestController
public class MoyenTransportController {

    @Autowired
    MoyenTransportService moyentransserv;
           
         @PostMapping("/addMoyenTransport")
         public MoyenTransport addMoyenTransport(@RequestBody MoyenTransport mt,@PathParam("id") int id) {
            return moyentransserv.addMoyenTransport(mt, id);
        }  
        
         @DeleteMapping("/deleteMoyenTransport/{mt}")
        public void deleteMoyenTransport(@PathVariable MoyenTransport mt) {
            moyentransserv.deleteMoyenTransport(mt); 
        }

}
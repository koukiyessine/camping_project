package com.example.camping.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.example.camping.project.Service.PaiementService;

@Controller
@RestController
public class PaiementController {
    
    @Autowired
    PaiementService paiementserv;
    
}
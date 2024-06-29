package com.example.camping.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.camping.project.Repository.PaiementRepository;
import com.example.camping.project.interfaceservice.IPaiementService;

@Service
public class PaiementService  implements IPaiementService {

    @Autowired
    PaiementRepository paiementrepo ;
    

}
package com.example.camping.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.camping.project.Repository.ReservationRepository;
import com.example.camping.project.interfaceservice.IReservationService;

@Service
public class ReservationService implements IReservationService{
    
    @Autowired
    ReservationRepository reservrepo;
}
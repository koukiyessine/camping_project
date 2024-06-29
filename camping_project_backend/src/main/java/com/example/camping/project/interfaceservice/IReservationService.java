package com.example.camping.project.interfaceservice;

import java.util.List;

import com.example.camping.project.Entities.Reservation;

public interface IReservationService {

        public Reservation addreservation(Reservation rsv);

        public List<Reservation> getallreservation(Reservation reserv);

        public int getnumdepersonnerservi();

        public void deleteReservation(Reservation reserv) ;

        public List<String> getAllDestinationByBudget(int budget) ;



}
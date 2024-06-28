package com.example.camping.project.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.camping.project.Entities.Reservation;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer>{

}
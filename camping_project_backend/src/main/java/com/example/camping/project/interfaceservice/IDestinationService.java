package com.example.camping.project.interfaceservice;

import com.example.camping.project.Entities.Destinations;
import java.util.List;

import jakarta.validation.Valid;

public interface IDestinationService {

    public Destinations addDestination(@Valid Destinations d);

    public List<Destinations> getallDestination();

    public Destinations updateDestinations(@Valid Destinations destinations, int id_destinations);

    public void deleteDestination(Destinations d);

    public List<Destinations> getallDestinationsbyville(String ch);

}
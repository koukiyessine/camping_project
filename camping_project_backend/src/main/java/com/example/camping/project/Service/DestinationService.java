package com.example.camping.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.camping.project.Entities.Destinations;
import com.example.camping.project.Repository.DestinationsRepository;
import com.example.camping.project.interfaceservice.IDestinationService;

import jakarta.validation.Valid;

@Service
public class DestinationService implements IDestinationService {

    @Autowired
    DestinationsRepository destrepo;

    @Override
    public Destinations addDestination(@Valid Destinations d) {
        return destrepo.save(d);
    }

    @Override
    public Destinations updateDestinations(@Valid Destinations destinations, int id_destinations) {

        Destinations ds = destrepo.findById(id_destinations).get();

        ds.setVille(destinations.getVille());
        ds.setType(destinations.getType());
        ds.setCapacite(destinations.getCapacite());
        destrepo.save(ds);
        return ds;
    }

    @Override
    public void deleteDestination(Destinations d) {
        destrepo.delete(d);
    }

    @Override
    public List<Destinations> getallDestination() {
        return (List<Destinations>) destrepo.findAll();
    }

    @Override
    public List<Destinations> getallDestinationsbyville(String ch) {
        return destrepo.findByville(ch);
    }

}
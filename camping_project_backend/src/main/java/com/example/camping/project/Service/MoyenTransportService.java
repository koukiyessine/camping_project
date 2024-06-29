package com.example.camping.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.camping.project.Entities.MoyenTransport;
import com.example.camping.project.Repository.CampingRepository;
import com.example.camping.project.Repository.MoyenTransportRepository;
import com.example.camping.project.interfaceservice.IMoyenTransportService;

@Service
public class MoyenTransportService implements IMoyenTransportService {

    @Autowired
    MoyenTransportRepository moyentransrep;

    @Autowired
    CampingRepository camprepo;

    @Override
    public MoyenTransport addMoyenTransport(MoyenTransport mt) {

        return moyentransrep.save(mt);
    }

    @Override
    public void deleteMoyenTransport(MoyenTransport mt) {
        moyentransrep.delete(mt);
    }
}
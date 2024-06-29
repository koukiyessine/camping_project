package com.example.camping.project.interfaceservice;

import com.example.camping.project.Entities.MoyenTransport;

public interface IMoyenTransportService {

        public MoyenTransport addMoyenTransport(MoyenTransport mt, int id);

        public void deleteMoyenTransport(MoyenTransport mt);
}

package com.example.camping.project.interfaceservice;

import java.util.List;

import com.example.camping.project.Entities.MoyenTransport;

public interface IMoyenTransportService {

        public MoyenTransport addMoyenTransport(MoyenTransport mt);
        public List<MoyenTransport> getallmoyentrans();
        public void deleteMoyenTransport(MoyenTransport mt);
        public int getnombredemoyentransdispo();
}

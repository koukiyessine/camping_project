package com.example.camping.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.camping.project.Service.Activiteservice;
import com.example.camping.project.Service.FilesStorageService;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class CampingProjectApplication implements CommandLineRunner {

	@Resource
	FilesStorageService filesStorageService;

	@Resource
	Activiteservice activiteservice ;
	public static void main(String[] args) {
		SpringApplication.run(CampingProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Storage initialisation");
		filesStorageService.init();
	}

}
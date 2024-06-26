package com.example.camping.project.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.camping.project.Entities.Guide;

@Repository
public interface GuideRepository extends CrudRepository<Guide, Integer>{   
     
}
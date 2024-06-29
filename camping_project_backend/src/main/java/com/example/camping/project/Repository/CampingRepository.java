package com.example.camping.project.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.camping.project.Entities.Camping;

@Repository
public interface CampingRepository extends CrudRepository<Camping, Integer> {

    List<Camping> findBydestinationStartingWith(String ch);

}
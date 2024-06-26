package com.example.camping.project.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.camping.project.Entities.User;
@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

    boolean existsBynom(String nom);

    List<User> findBynom(String ch);

    
}
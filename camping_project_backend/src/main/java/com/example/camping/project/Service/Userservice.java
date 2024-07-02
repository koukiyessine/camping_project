package com.example.camping.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.camping.project.Entities.User;
import com.example.camping.project.Repository.UserRepository;
import com.example.camping.project.interfaceservice.IUserservice;

import jakarta.validation.Valid;

@Service
public class Userservice implements IUserservice {

    @Autowired
    UserRepository userrep;



    @Override
    public User adduser(@Valid User u) {
       return userrep.save(u);
    }
/* 
    @Override
    public String adduserwihconf(@Valid User u){
         String ch="";
         if(u.getPassword().equals(u.getConfpassword())){
            userrep.save(u);
         } else{
            ch="confirmed password is wrong ! " ;
         }
        return ch;
    } */

    @Override
    public String adduserwithexistence(@Valid User u) {
        String ch="";
        if(userrep.existsBynom(u.getNom())){
            ch="username already exist dans bd !";
        }else{
            userrep.save(u);
            ch="user est created !";
        }
        return ch; 
    }

    @Override
    public User updateuser(@Valid User user, int id_user) {
         
        User us=userrep.findById(id_user).get();
           
        us.setNom(user.getNom());
        us.setPrenom(user.getPrenom());
        us.setLogin(user.getLogin());
        us.setPassword(user.getPassword());
        userrep.save(us);
        return us;
    }

    @Override
    public void deleteuser(User u) {
        userrep.delete(u);
    }

    @Override
    public List<User> getallUser() {
        return (List<User>) userrep.findAll();
    }

    @Override
    public List<User> getalluserbyname(String ch) {
      return userrep.findBynom(ch);
    }
        

    @Override
    public int getnombreuserdispo(){
       return (int) userrep.count();
    }
            

}
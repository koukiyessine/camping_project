package com.example.camping.project.interfaceservice;


import java.util.List;

import com.example.camping.project.Entities.User;

public interface IUserservice {

    public User adduser(User u);
    public String adduserwihconf(User u);
    public String adduserwithexistence(User u);
    public User updateuser(User user , int id_user);
    public void deleteuser(User u);
    public List <User> getallUser();
    public List <User> getalluserbyname(String ch); 
    public int getnombreuserdispo() ;

}
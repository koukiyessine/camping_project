package com.example.camping.project.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.camping.project.Entities.User;
import com.example.camping.project.Service.Userservice;

import java.util.List;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RestController
public class Usercontroller {

@Autowired
Userservice userserv;

    @PostMapping("/adduser")
    public User adduser(@RequestBody User u){
        return userserv.adduser(u);
    }

    @PostMapping("/adduserbyconf")
    public String adduserwihconf(@RequestBody User u){
        return userserv.adduserwihconf(u) ;
    }

    @PostMapping("/adduserwithexistence")
    public String adduserwithexistence(@RequestBody User u){
      return userserv.adduserwithexistence(u);
    }
  
    @PutMapping("/updateuser/{id}")
    public User updateuser(@RequestBody User user,@PathVariable("id") int id_user){
        return userserv.updateuser(user, id_user);
    }

    @DeleteMapping("/deleteuser")
    public void deleteuser(@PathParam("id_user") User u){
     userserv.deleteuser(u);
    }

    @GetMapping("/getallUser")
    public List<User> getallUser() {
        return userserv.getallUser();
    }


    @GetMapping("/getalluserbyname/{ch}")
    public List<User> getalluserbyname(@PathVariable String ch) {
      return userserv.getalluserbyname(ch);
    }
}

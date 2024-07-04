package com.example.camping.project.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.camping.project.Entities.User;
import com.example.camping.project.Service.Userservice;

import java.util.List;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

@Controller
@RestController
@PreAuthorize("hasAnyRole('ADMIN','USER')")
public class Usercontroller {

@Autowired
Userservice userserv;
/*  
    @PostMapping("/adduser")
    @PreAuthorize("hasAuthority('WRITE_PRIVILEGE') and hasRole('ADMIN','USER')")
    public User adduser(@RequestBody User u){
        return userserv.adduser(u);
    }

   @PostMapping("/adduserbyconf")
    public String adduserwihconf(@RequestBody User u){
        return userserv.adduserwihconf(u) ;
    } */

/*     @PostMapping("/adduserwithexistence")
    public String adduserwithexistence(@RequestBody User u){
      return userserv.adduserwithexistence(u);
    }
  
    @PutMapping("/updateuser/{id}")
    public User updateuser(@RequestBody User user,@PathVariable("id") int id_user){
        return userserv.updateuser(user, id_user);
    } */

    @DeleteMapping("/deleteuser")
    @PreAuthorize("hasAuthority('DELETE_PRIVILEGE') and hasRole('ADMIN')")
    public void deleteuser(@PathParam("id_user") User u){
     userserv.deleteuser(u);
    }

    @GetMapping("/getallUser")
    @PreAuthorize("hasAnyRole('ADMIN') and hasAuthority('READ_PRIVILEGE')")
    public List<User> getallUser() {
        return userserv.getallUser();
    }


    @GetMapping("/getalluserbyname/{ch}")
    @PreAuthorize("hasAnyRole('ADMIN') and hasAuthority('READ_PRIVILEGE')")
    public List<User> getalluserbyname(@PathVariable String ch) {
      return userserv.getalluserbyname(ch);
    }

    @GetMapping("/getnombreuserdispo")
    @PreAuthorize("hasAnyRole('ADMIN') and hasAuthority('READ_PRIVILEGE')")
    public int getnombreuserdispo(){
     return userserv.getnombreuserdispo() ;
    }
}

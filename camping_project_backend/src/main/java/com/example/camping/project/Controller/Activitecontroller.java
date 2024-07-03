package com.example.camping.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.camping.project.Entities.Activite;
import com.example.camping.project.Service.Activiteservice;

import jakarta.validation.Valid;

@RestController
@PreAuthorize("hasAnyRole('ADMIN','USER')")
public class Activitecontroller {

  @Autowired
  Activiteservice actserv;

  @PostMapping("/addActivite")
  @PreAuthorize("hasAuthority('WRITE_PRIVILEGE') and hasRole('ADMIN')")
  public Activite addActivite(@RequestBody Activite A) {
    return actserv.addActivite(A);
  }

  @PutMapping("/updateActivite/{id}")
  @PreAuthorize("hasAuthority('UPDATE_PRIVILEGE') and hasRole('ADMIN')")
  public Activite updateActivite(@Valid @RequestBody Activite activ, @PathVariable("id") int id_activite) {
    return actserv.updateActivite(activ, id_activite);
  }

  @DeleteMapping("/deleteActivite/{id}")
  @PreAuthorize("hasAuthority('DELETE_PRIVILEGE') and hasRole('ADMIN')")
  public void deleteActivite(@PathVariable("id") Activite actv) {
    actserv.deleteActivite(actv);
  }

  @GetMapping("/getallActivite")
  @PreAuthorize("hasAnyRole('ADMIN', 'USER') and hasAuthority('READ_PRIVILEGE')")
  public List<Activite> getallActivite() {
    return actserv.getallActivite();
  }

  @GetMapping("/getallActivitebynom/{ch}")
  @PreAuthorize("hasAnyRole('ADMIN', 'USER') and hasAuthority('READ_PRIVILEGE')")
  public String getallActivitebynom(@PathVariable("ch") String ch) {

    return actserv.getallActivitebynom(ch);
  }

  @GetMapping("/getnombreActivitedispo")
  @PreAuthorize("hasAnyRole('ADMIN', 'USER') and hasAuthority('READ_PRIVILEGE')")
  public int getnombreActivitedispo() {
    return actserv.getnombreActivitedispo();
  }

  @PatchMapping("/updateActiviteImage/{id}")
  @PreAuthorize("hasAuthority('UPDATE_PRIVILEGE') and hasRole('ADMIN')")
  public Activite updateActiviteImage(@PathVariable int id, @RequestParam("file") MultipartFile file) {
    return actserv.updateActiviteImage(id, file);
  }
}
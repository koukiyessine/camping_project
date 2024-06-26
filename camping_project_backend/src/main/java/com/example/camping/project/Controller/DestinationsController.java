package com.example.camping.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.camping.project.Entities.Destinations;
import com.example.camping.project.Service.DestinationService;

import java.util.List;

import jakarta.validation.Valid;

@Controller
@RestController
public class DestinationsController {

  @Autowired
  DestinationService destserv;

  @PostMapping("/addDestination")
  public Destinations addDestination(@RequestBody @Valid Destinations d) {
    return destserv.addDestination(d);
  }

  @GetMapping("/getallDestination")
  public List<Destinations> getallDestination() {
    return destserv.getallDestination();

  }

  @PutMapping("/updateDestinations/{id}")
  public Destinations updateDestinations(@RequestBody @Valid Destinations destinations,
      @PathVariable("id") int id_destinations) {
    return destserv.updateDestinations(destinations, id_destinations);
  }

  @DeleteMapping("/deleteDestination/{d}")
  public void deleteDestination(@PathVariable Destinations d) {
    destserv.deleteDestination(d);
  }

  @GetMapping("/getallDestinationsbyville/{ch}")
  public List<Destinations> getallDestinationsbyville(@PathVariable String ch) {
    return destserv.getallDestinationsbyville(ch);
  }

}
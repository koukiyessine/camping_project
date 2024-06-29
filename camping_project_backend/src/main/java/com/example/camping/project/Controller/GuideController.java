package com.example.camping.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.camping.project.Entities.Guide;
import com.example.camping.project.Service.GuideService;

import jakarta.websocket.server.PathParam;

@Controller
@RestController
public class GuideController {

    @Autowired
    GuideService guideserv;

    @PostMapping("/addGuide")
    public Guide addGuide(@RequestBody Guide g ,@PathParam("id_camping")  int id_camping) {
        return guideserv.addGuide(g,id_camping);
    }

    @GetMapping("/getallGuide")
    public List<Guide> getallGuide() {

        return guideserv.getallGuide();
    }


    @GetMapping("/getallGuidebynomGuide/{ch}")
    public List<Guide> getallGuidebynomGuide(@PathVariable String ch) {
      return guideserv.getallGuidebynomGuide(ch);
    }
    
    @PutMapping("/updateGuide/{id_Guide}")
    public Guide updateGuide(@RequestBody Guide guide,@PathVariable int id_Guide){
        return guideserv.updateGuide(guide , id_Guide);
    }


}
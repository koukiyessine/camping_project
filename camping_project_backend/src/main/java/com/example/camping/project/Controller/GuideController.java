package com.example.camping.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.camping.project.Entities.Guide;
import com.example.camping.project.Service.GuideService;

@Controller
@RestController
public class GuideController {

    @Autowired
    GuideService guideserv;

    @PostMapping("/addGuide")
    public Guide addGuide(@RequestBody Guide g) {
        return guideserv.addGuide(g);
    }

}
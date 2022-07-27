package com.renters_right_backend.renters_demo.controllers;


import java.util.List;

import com.renters_right_backend.renters_demo.model.Volunteer;
import com.renters_right_backend.renters_demo.repositories.VolunteerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;

@Controller
public class VolunteerController {
    @Autowired
    private VolunteerRepository volunteerRepo;

    @GetMapping("/volunteers")
    public String listAll(Model model) {
        List<Volunteer> listVolunteers = volunteerRepo.findAll() ;
        model.addAttribute("listVolunteers", listVolunteers);

        return "volunteers";
    }

    
}

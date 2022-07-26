package com.renters_right_backend.renters_demo.controllers;


import java.util.List;

import com.renters_right_backend.renters_demo.model.Volunteer;
import com.renters_right_backend.renters_demo.repositories.VolunteerRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VolunteerController {

    private final VolunteerRepository repository;

    VolunteerController(VolunteerRepository repository){
        this.repository = repository;
    }

    @GetMapping(path="/")
    List<Volunteer> all(){
        return repository.findAll();
    }

    
}

package com.renters_right_backend.renters_demo.controllers;


import java.util.List;
import java.util.Optional;

import com.renters_right_backend.renters_demo.model.Volunteer;
import com.renters_right_backend.renters_demo.repositories.VolunteerRepository;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class VolunteerController {

    // injecting controsctor into controller
    // @Autowired
    private VolunteerRepository repository;

    // I think this just defines the repository I reference later?
    VolunteerController(VolunteerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/volunteers")
    List<Volunteer> all() {
        return repository.findAll();
    }

    @PostMapping("/volunteers")
    Volunteer newVolunteer(@RequestBody Volunteer newVolunteer) {
        return repository.save(newVolunteer);
    }

    @GetMapping("/volunteers/{id}")
    Optional<Volunteer> one(@PathVariable Integer id) {

        return repository.findById(id)
    }
    
}

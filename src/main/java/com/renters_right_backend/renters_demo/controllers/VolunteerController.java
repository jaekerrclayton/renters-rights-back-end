package com.renters_right_backend.renters_demo.controllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.renters_right_backend.renters_demo.model.Volunteer;
import com.renters_right_backend.renters_demo.repositories.VolunteerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class VolunteerController {

    @Autowired
    VolunteerRepository volunteerRepository;

    @GetMapping("/volunteers")
    public List<Volunteer> getAllVolunteer(){
        List<Volunteer> allVolunteerlist = volunteerRepository.findAll();
        return allVolunteerlist;
    }

    @GetMapping("/volunteers/{id}")
    public Volunteer getVolunteerbyId(@PathVariable(value = "id") Integer volunteerId)

    {
        Volunteer volunteer = volunteerRepository.findById(volunteerId).get();

        return volunteer;
    }


    @PostMapping("/create-volunteer")
    public Volunteer createVolunteer(@RequestBody Volunteer volunteer) {

        Volunteer savedVolunteer= volunteerRepository.save(volunteer);

        return savedVolunteer;
    }


    @PutMapping("/volunteers/{id}")
    public ResponseEntity<Volunteer> updateEmployee(@PathVariable(value = "id") Integer volunteerId,
                                                         @RequestBody Volunteer volunteerDetails) {
        Volunteer volunteer = volunteerRepository.findById(volunteerId).get();

        volunteer.setStatus(volunteerDetails.getStatus());
        volunteer.setSchedule(volunteerDetails.getSchedule());
        final Volunteer updatedVolunteer = volunteerRepository.save(volunteer);
        return ResponseEntity.ok(updatedVolunteer);
    }

    @DeleteMapping("/volunteers/{id}")
    public Map<String, Boolean> deleteVolunteer(@PathVariable(value = "id") Integer volunteerId)
    {
        Volunteer volunteer = volunteerRepository.findById(volunteerId).get();

        volunteerRepository.delete(volunteer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted {id}", Boolean.TRUE);
        return response;
    }









    // private final VolunteerRepository repository;

    // VolunteerController(VolunteerRepository repository){
    //     this.repository = repository;
    // }

    // @GetMapping(path="/")
    // List<Volunteer> all(){
    //     return repository.findAll();
    // }

    
}

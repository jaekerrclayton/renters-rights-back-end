package com.renters_right_backend.renters_demo.controllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.renters_right_backend.renters_demo.model.Volunteer;
import com.renters_right_backend.renters_demo.repositories.VolunteerRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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

        return repository.findById(id);
    }

    @PatchMapping("/volunteers/{id}")
    public ResponseEntity<Volunteer> updateVolunteer(@PathVariable(value = "id") Integer volunteerId,
                                                        @RequestBody Volunteer volunteerDetails) {
        Volunteer volunteer = repository.findById(volunteerId).get();

        volunteer.setStatus(volunteerDetails.getStatus());
        // want to allow patch without impacting the schedule !! 
        volunteer.setSchedule(volunteerDetails.getSchedule());
        final Volunteer updatedVolunteer = repository.save(volunteer);
        return ResponseEntity.ok(updatedVolunteer);
    }

    @DeleteMapping("/volunteers/{id}")
    public Map<String, Boolean> deleteVolunteer(@PathVariable(value = "id") Integer volunteerId)
    {
        Volunteer volunteer = repository.findById(volunteerId).get();
        repository.delete(volunteer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted {id}", Boolean.TRUE);
        return response;
    }

}

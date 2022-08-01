package com.renters_right_backend.renters_demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renters_right_backend.renters_demo.model.Schedule;
import com.renters_right_backend.renters_demo.repositories.ScheduleRepository;
import com.renters_right_backend.renters_demo.repositories.VolunteerRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/admin")
public class ScheduleController {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private VolunteerRepository volunteerRepository;

    @GetMapping("/schedules")
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    @GetMapping("/volunteers/{volunteerId}/schedules")
    public Schedule getScheduleByVolunteerId(@PathVariable Integer volunteerId) {
    	List<Schedule> schedules = scheduleRepository.findByVolunteerId(volunteerId);
        return schedules.get(0);
    }

    @PostMapping("/volunteers/{volunteerId}/schedules")
    public Schedule addSchedule(@PathVariable Integer volunteerId,
                                @Valid @RequestBody Schedule schedule) {
                                    try {
                                        return volunteerRepository.findById(volunteerId)
                                        .map(volunteer -> {
                                            schedule.setVolunteer(volunteer);
                                            return (scheduleRepository.save(schedule));
                                        }).orElseThrow(() -> new NotFoundException());
                                    } catch (NotFoundException e) {
                                        e.printStackTrace();
                                    }
                                    return schedule;
                                }

    @PutMapping("/schedules/{scheduleId}")
    public Schedule updateSchedule(@PathVariable Integer scheduleId,
                                    @Valid @RequestBody Schedule scheduleUpdated) {
                                        try {
                                            return scheduleRepository.findById(scheduleId)
                                            .map(schedule -> {
                                                schedule.setFri(scheduleUpdated.getFri());
                                                schedule.setSat(scheduleUpdated.getSat());
                                                schedule.setSun(scheduleUpdated.getSun());
                                                schedule.setMon(scheduleUpdated.getMon());
                                                schedule.setTue(scheduleUpdated.getTue());
                                                schedule.setWed(scheduleUpdated.getWed());
                                                schedule.setThu(scheduleUpdated.getThu());
                                                return (scheduleRepository.save(schedule));
                                            }).orElseThrow(() -> new NotFoundException());
                                        } catch (NotFoundException e) {
                                            e.printStackTrace();
                                        }
                                        return scheduleUpdated;
                                    }

}

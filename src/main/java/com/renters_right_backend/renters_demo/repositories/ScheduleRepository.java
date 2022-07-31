package com.renters_right_backend.renters_demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renters_right_backend.renters_demo.model.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    List<Schedule> findByVolunteerId(Integer volunteer_id);
}
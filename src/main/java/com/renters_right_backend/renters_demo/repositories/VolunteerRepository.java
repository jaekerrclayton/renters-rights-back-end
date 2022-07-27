package com.renters_right_backend.renters_demo.repositories;

import com.renters_right_backend.renters_demo.model.Volunteer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer, Integer>{
    
}

package com.renters_right_backend.renters_demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="volunteers")
public class Volunteer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id; 
    private String name;
    private String type;
    private String email; 
    private String schedule;
    private String status; 
    private String language; 

    public Volunteer() {}

    public Volunteer(
        Integer id, 
        String name, 
        String type, 
        String email, 
        String schedule, 
        String status, 
        String language)
        
        {

            this.id = id;
            this.name = name; 
            this.type = type;
            this.email= email;
            this.schedule = schedule;
            this.status  = status;
            this.language = language;

        }

    public Integer getId(){
        return id;
    }

    public String getName(){
        return name;
    }


    public String getType(){
        return type;
    }


    public String getEmail(){
        return email;
    }


    public String getLanguage(){
        return language;
    }


    public String getSchedule(){
        return schedule;
    }


    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }
    
    public void setSchedule(String schedule){
        this.schedule = schedule;
    }
}

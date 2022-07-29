package com.renters_right_backend.renters_demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="volunteers")
public class Volunteer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name", nullable=false)
    private String name;

    @NotEmpty(message = "The email address is required")
    @Email(message = "The email address is ivalid.")
    private String email; 

    private String schedule;
    private String status; 
    private String language; 
    private String type;


    public Volunteer(){};

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


    public Integer getVolunteerId(){
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
    public void setSchedule(String schedule){
        this.schedule = schedule;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }

    @Override
    public String toString() {
        return "Volunteer [id=" + id + ", name=" + name + ", email=" + email
                + ", status=" + status + ", schedule=" + schedule + ", type=" + type + ", language=" + language + "]";
    }
}
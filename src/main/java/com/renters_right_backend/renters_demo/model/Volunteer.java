package com.renters_right_backend.renters_demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="volunteers")
public class Volunteer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "The name is required.")
    private String name;

    @Email(message = "The email address is ivalid.")
    private String email; 

    @OneToOne(mappedBy= "volunteer", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = {"volunteerBySchedule", "handler", "hibernateLazyInitializer"}, allowSetters = true)
    @PrimaryKeyJoinColumn
    private Schedule schedule;

    private String status;

    @NotNull(message = "A language key must be present even if empty.")
    private String language;

    @NotEmpty(message = "Type of volunteer is required information.")
    private String type;


    public Volunteer(){
        this.status = "offline";
    };

    public Volunteer(
        Integer id, 
        String name, 
        String type, 
        String email, 
        Schedule schedule,
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
    public Schedule getSchedule(){
        return schedule;
    }
    public void setSchedule(Schedule schedule){
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
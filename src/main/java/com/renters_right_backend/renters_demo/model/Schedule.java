package com.renters_right_backend.renters_demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "schedules")
public class Schedule{

    @Id
    @Column(name = "volunteer_id")
    private Integer id;

    private String sun;
    private String mon;
    private String tue;
    private String wed;
    private String thu;
    private String fri;
    private String sat;

    @OneToOne
    @MapsId
    @JsonIgnoreProperties(value = {"schedule", "handler", "hibernateLazyInitializer"}, allowSetters = true)
    @JoinColumn(name = "volunteer_id")
    private Volunteer volunteer;

    public Schedule() {}

    public Schedule(
        String sun,
        String mon,
        String tue,
        String wed,
        String thu,
        String fri,
        String sat
    ) {
        this.sun = sun;
        this.mon = mon;
        this.tue = tue;
        this.wed = wed;
        this.thu = thu;
        this.fri = fri;
        this.sat = sat;
    }

    public Volunteer getVolunteerBySchedule(){
        return volunteer;
    }
    public String getSun(){
        return sun;
    }
    public String getMon(){
        return mon;
    }
    public String getTue(){
        return tue;
    }
    public String getWed(){
        return wed;
    }
    public String getThu(){
        return thu;
    }
    public String getFri(){
        return fri;
    }
    public String getSat(){
        return sat;
    }
    public void setSun(String sun){
        this.sun = sun;
    }
    public void setMon(String mon){
        this.mon = mon;
    }
    public void setTue(String tue){
        this.tue = tue;
    }
    public void setWed(String wed){
        this.wed = wed;
    }
    public void setThu(String thu){
        this.thu = thu;
    }
    public void setFri(String fri){
        this.fri = fri;
    }
    public void setSat(String sat){
        this.sat = sat;
    }
    public void setVolunteer(Volunteer volunteer){
        this.volunteer = volunteer;
    }
    @Override
    public String toString() {
        return "Schedule [id=" + id + ", sun=" + sun + ", mon=" + mon
                + ", tue=" + tue + ", wed=" + wed + ", thu=" + thu + ", fri=" + fri + ", sat=" + sat + "]";
    }
}

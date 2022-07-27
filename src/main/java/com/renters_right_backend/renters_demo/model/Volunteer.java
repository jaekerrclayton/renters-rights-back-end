package com.renters_right_backend.renters_demo.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="volunteers")
public class Volunteer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer volunteerId;

    @Column(name = "name", nullable=false)
    private String name;


    @Column(name = "email", nullable = false)
    private String email; 

    @Column(name = "schedule")
    private String schedule;


    @Column(name = "status")
    private String status; 


    @Column(name = "language")
    private String language; 


      // **** SOME WAY TO SRT BY TYPE : maybe list?? 
    @Column(name = "type")
    private String type;
  




    public Volunteer(
        Integer volunteerId, 
        String name, 
        String type, 
        String email, 
        String schedule, 
        String status, 
        String language)
        
        {

            this.volunteerId = volunteerId;
            this.name = name; 
            this.type = type;
            this.email= email;
            this.schedule = schedule;
            this.status  = status;
            this.language = language;

        }




    public Integer getVolunteerId(){
        return volunteerId;
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
        return "Volunteer [volunteerId=" + volunteerId + ", name=" + name + ", email=" + email
                + ", status=" + status + ", schedule=" + schedule + ", type=" + type + ", language=" + language + "]";
    }


}








    


    



   /*
   sched times : morn afternoon evening 
   day: m, t, w, tr, fr, sat, sun 
   
   {day : shift}*/


    

//    @Override
//     public int hashCode() {
//         int hash = 7;
//         hash = 79 * hash + Objects.hashCode(this.id);
//         hash = 79 * hash + Objects.hashCode(this.name);
//         hash = 79 * hash + this.population;
//         return hash;
//     }



    


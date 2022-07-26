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






    
}

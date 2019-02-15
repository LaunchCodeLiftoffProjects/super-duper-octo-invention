package com.teacher.teacherscheduler.models;

import org.hibernate.validator.constraints.Email;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity //specify this annotation as store this class in DB
public class Teacher {


    @Id
    @GeneratedValue // this create unique id for every student.
    private int id;


    @NotNull
    @Size(min=5, max = 15, message="Please enter valid Name")
    private String name;



    @NotNull
    @Email
    @Size(min=10,max=25, message= "Please enter valid emailID")



    private String emailId ;

    // Default constructor is used for main
    public Teacher(){

    }

    // this constructor used for parameterised

    public Teacher(String name,  String emailId) {
        this.name = name;

        this.emailId = emailId;
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setTeacher(Teacher teacher) {
    }
}

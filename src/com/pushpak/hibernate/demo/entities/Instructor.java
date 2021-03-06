package com.pushpak.hibernate.demo.entities;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

//annotate the class as an entity and map to db table
@Entity
@Table(name = "instructor")
public class Instructor
{

    // define the fields // annotate the fields with db column names
    @Id
    @GenericGenerator(name = "myGenerator", strategy = "increment")
    @GeneratedValue(generator = "myGenerator")
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    // its details obj { Instructor has details : one to one mapping }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    private InstructorDetail instructorDetail;

    // create constructor
    public Instructor() {
    }

    public Instructor(String firstName, String lastName, String email) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
    }

   //constructor to auto generate email
    public Instructor(String firstName, String lastName) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = firstName + "." + lastName + "@gmail.com";
    }
    
    // generate getter setter
    public int getId()
    {
	return id;
    }

    public void setId(int id)
    {
	this.id = id;
    }

    public String getFirstName()
    {
	return firstName;
    }

    public void setFirstName(String firstName)
    {
	this.firstName = firstName;
    }

    public String getLastName()
    {
	return lastName;
    }

    public void setLastName(String lastName)
    {
	this.lastName = lastName;
    }

    public String getEmail()
    {
	return email;
    }

    public void setEmail(String email)
    {
	this.email = email;
    }

    public InstructorDetail getInstructorDetail()
    {
	return instructorDetail;
    }

    public void setInstructorDetail(InstructorDetail instructorDetail)
    {
	this.instructorDetail = instructorDetail;
    }

    // generate to string
    @Override
    public String toString()
    {
	return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
		+ ", instructorDetail=" + instructorDetail + "]";
    }

}

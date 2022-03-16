package com.pushpak.hibernate.demo.entities;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

//annotate the class as an entity and map to db table
@Entity
@Table(name = "instructor_detail")
public class InstructorDetail
{
    // define the fields // annotate the fields with db column names
    
        @Id
        @GenericGenerator(name = "myGenerator", strategy = "increment")
	@GeneratedValue(generator = "myGenerator")
	@Column(name="id")
	private int id;

    @Column(name = "ytChannel")
    private String ytChannel;

    @Column(name="hobby")
    private String hobby;

    // create constructor
    public InstructorDetail() {
    }

    // id is auto generated
    public InstructorDetail(String ytChannel, String hobby) {
	this.ytChannel = ytChannel;
	this.hobby = hobby;
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

    public String getYtChannel()
    {
	return ytChannel;
    }

    public void setYtChannel(String ytChannel)
    {
	this.ytChannel = ytChannel;
    }

    public String getHobby()
    {
	return hobby;
    }

    public void setHobby(String hobby)
    {
	this.hobby = hobby;
    }

    // generate to string
    @Override
    public String toString()
    {
	return "InstructorDetail [id=" + id + ", ytChannel=" + ytChannel + ", hobby=" + hobby + "]";
    }

}

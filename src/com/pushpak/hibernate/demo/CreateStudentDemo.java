package com.pushpak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pushpak.hibernate.demo.entities.Student;

public class CreateStudentDemo
{

    public static void main(String[] args)
    {
	// create SessionFactory
	SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

	// create Session
	Session session = factory.getCurrentSession();

	try
	{
	    // create a student obj
	    Student student = new Student("Paul", "Wall", "PaulWall@gmail.com");

	    // start transaction
	    session.beginTransaction();

	    // save the student
	    session.save(student);

	    // commit transaction
	    session.getTransaction().commit();

	    System.out.println("saved student with ID = " + student.getId());

	    // close session
	    session.close();

	} catch (Exception e)
	{
	    e.printStackTrace();
	}
	finally
	{
	    factory.close();
	}
    }
}

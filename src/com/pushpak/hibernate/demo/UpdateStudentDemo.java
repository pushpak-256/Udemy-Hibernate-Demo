package com.pushpak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pushpak.hibernate.demo.entities.Student;

public class UpdateStudentDemo
{

    public static void main(String[] args)
    {
	// create SessionFactory
	SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

	// create Session
	Session session = factory.getCurrentSession();

	try
	{
            int id = 1;
	    
	    // start transaction
	    session.beginTransaction();

	    // retrieve the student
             Student student = session.get(Student.class, id);
             
             System.out.println("Before \n"+student);

             //update values
             student.setFirstName("Scooby");
             
	    // commit transaction
	    session.getTransaction().commit();

	    System.out.println("\nupdated student with ID = " + student.getId()+"\nAfter"+student);


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

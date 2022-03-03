package com.pushpak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pushpak.hibernate.demo.entities.Student;

public class ReadStudentDemo
{

    public static void main(String[] args)
    {
	// create SessionFactory
	SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

	// create Session
	Session session = factory.getCurrentSession();

	try
	{
	    //STORE
	    
	    // create a student obj
	    Student student = new Student("RONI", "RONI", "daffy11@gmail.com");

	    // start transaction
	    session.beginTransaction();

	    System.out.println(student);
	    
	    // save the student
	     session.save(student);

	    // commit transaction
	    session.getTransaction().commit();

	    System.out.println("saved student with ID = " + student.getId()+"\n"+student.toString()+"\n"+session+"_________________\n\n");

	    
	    
	    
	    
	    // my new code // RETRIVE 
	    
	    // get session
	    session = factory.getCurrentSession();
	    
	    // begin transaction
	    session.beginTransaction();
	    
	    //read from db
	    student = session.get(Student.class, student.getId());
	    
	    
	    // commit transaction  //this step closes current session
	  //  session.getTransaction().commit();
	    
	    System.out.println(student+"\n"+session);
	    
	    //dont need to close session explicitly
	    // close session
	   // session.close();
	 
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

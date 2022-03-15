package com.pushpak.hibernate.Mappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pushpak.hibernate.demo.entities.Instructor;
import com.pushpak.hibernate.demo.entities.InstructorDetail;

public class One_to_One_Demo
{

    public static void main(String[] args)
    {
	// create SessionFactory
	SessionFactory factory = new Configuration().configure().addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class).buildSessionFactory();

	// create Session
	Session session = factory.getCurrentSession();

	try
	{
	
	    //create the objects
	    Instructor instructor = new Instructor("Pushpak", "Bhagat", "myemail@xyz.com");
	    
	    InstructorDetail instructorDetail = new InstructorDetail("YT-Channel", "hobby");
	    
	    //associate the objects
	    instructor.setInstructorDetail(instructorDetail);

	    // start transaction
	    session.beginTransaction();

	   //save Instructor , //NOTE: cascade will save Instructor details too
             session.save(instructor);
	    
             System.out.println("\n"+instructor+"\n");
             
	    // commit transaction
	    session.getTransaction().commit();

	    // close session
	    session.close();

	} catch (Exception e)
	{
	    System.out.println("something went wrong while saving ");
	    e.printStackTrace();
	}
	finally
	{
	    factory.close();
	}
    }

}

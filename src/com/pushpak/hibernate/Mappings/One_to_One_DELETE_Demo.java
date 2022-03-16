package com.pushpak.hibernate.Mappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pushpak.hibernate.demo.entities.Instructor;
import com.pushpak.hibernate.demo.entities.InstructorDetail;

public class One_to_One_DELETE_Demo
{

    public static void main(String[] args)
    {
	// create SessionFactory
	SessionFactory factory = new Configuration().configure().addAnnotatedClass(InstructorDetail.class)
		.addAnnotatedClass(Instructor.class).buildSessionFactory();

	// create Session
	Session session = factory.getCurrentSession();

	try
	{

	    // start transaction
	    session.beginTransaction();

	    // get instructor by primary key / id

	    int id = 2;
	    Instructor instructor = session.get(Instructor.class, id);

	    // delete instructor
	    if (instructor != null)
	    {
		System.out.println("\n" + instructor + "\n");
		
		/*
		 * NOTE : It will also delete Instructor_Detail 
		 *  coz of CascadeType.ALL	 
		*/
		session.delete(instructor);
	    } else
	    {
		System.err.println("Instructor with id " + id + " not found");
	    }
	    
	    // commit transaction
	    session.getTransaction().commit();

	    // close session
	    session.close();

	} catch (Exception e)
	{
	    System.out.println("something went wrong while saving ");
	    e.printStackTrace();
	} finally
	{
	    factory.close();
	}
    }

}

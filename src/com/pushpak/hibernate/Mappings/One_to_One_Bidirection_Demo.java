package com.pushpak.hibernate.Mappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pushpak.hibernate.demo.entities.Instructor;
import com.pushpak.hibernate.demo.entities.InstructorDetail;

public class One_to_One_Bidirection_Demo
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
	    
	    //1 get InstructorDetail obj 
	    int id = 54;
	   
	     InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
	    
	    //print it 
	     System.out.println("\n"+instructorDetail+"\n");
	    
	    // 2 .print Associated Instructor;    
	     System.out.println("\n"+instructorDetail.getInstructor()+"\n");
	     
	    // commit transaction
	    session.getTransaction().commit();

	    // close session
	    session.close();

	} catch (Exception e)
	{
	    System.out.println("something went wrong  ");
	    e.printStackTrace();
	} finally
	{
	    // to fix connection leak issue
	    session.close();
	    factory.close();
	}
    }

}

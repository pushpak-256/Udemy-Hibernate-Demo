package com.pushpak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pushpak.hibernate.demo.entities.Student;

public class DeleteStudentDemo
{

    public static void main(String[] args)
    {
	// create SessionFactory
	SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

	// create Session
	Session session = factory.getCurrentSession();

	try
	{
	    int id =2;

	    // start transaction
	    session.beginTransaction();

	    // retrieve the student
	    Student student = session.get(Student.class, id);

	    //check if student is present in table
	    if (student != null)
	    {
		 System.out.println("deleting " + student);
		 
		// delete student
		session.delete(student);

		// commit transaction
		session.getTransaction().commit();
		
		System.out.println("deleted student with id = " + id + "\n");
	    } 
	    else
	    {
		System.out.println("Student with id " + id + " not found.");
	    }

	} catch (Exception e)
	{
	    e.printStackTrace();
	} finally
	{
	    factory.close();
	}
    }
}

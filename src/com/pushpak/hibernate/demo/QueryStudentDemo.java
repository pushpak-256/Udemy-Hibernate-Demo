package com.pushpak.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pushpak.hibernate.demo.entities.Student;

public class QueryStudentDemo
{

    public static void main(String[] args)
    {
	SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

	Session session = factory.getCurrentSession();
	try
	{
	    // start Transaction
	    session.beginTransaction();

	    // query Students
	    List<Student> studentList = session.createQuery("from Student").getResultList();

	    // display students
	    displayStudents(studentList);

	    // querylast name='Wall'
	    studentList = session.createQuery("from Student x where x.lastName='Wall'").getResultList();

	    // display students
	    System.out.println("\n\nStudents with lastName");
	    displayStudents(studentList);

	    // querylast with // or
	    studentList = session.createQuery("from Student x where x.lastName='Wall' or x.firstName='Daffy'")
		    .getResultList();

	    // display students
	    System.out.println("\n\nStudents with lastName or fistName");
	    displayStudents(studentList);

	    // querylast with // or
	    studentList = session.createQuery("from Student x where x.email like '%gmail.com'").getResultList();

	    // display students
	    System.out.println("\n\nStudents with email ending with gmail.com");
	    displayStudents(studentList);

	    // commit transaction
	    session.getTransaction().commit();

	} finally
	{
	    factory.close();
	}
    }

    private static void displayStudents(List<Student> studentList)
    {
	for (Student student : studentList)
	{
	    System.out.println(student);
	}
    }

}

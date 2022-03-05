package com.pushpak.hibernate.practiceActivity.EmployeeApp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeOperations
{
    // create SessionFactory
    SessionFactory factory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();

    Session session;

    public void addEmployee(Employee emp)
    {
	try
	{
	    session = factory.getCurrentSession();
	    session.beginTransaction();
	    
	    if(session.save(emp)==null) {System.out.println("\nsomething went wrong while saving in db");}
	    else System.out.println("--\nsaved--"+emp+"\n");
	    
	    session.getTransaction().commit();
	} catch (Exception e)
	{
	    System.out.println("something went Wrong in method #" + new Object() {}.getClass().getEnclosingMethod().getName() + "()#");
	    e.printStackTrace();
	}
	
    }

    public Employee getEmoplyee(int id)
    {
	try
	{
	    session = factory.getCurrentSession();
	    session.beginTransaction();
	    
	    Employee emp =session.get(Employee.class, id);
	    
	    session.getTransaction().commit();
	    return emp;
	} catch (Exception e)
	{
	    System.out.println("something went Wrong in method #" + new Object(){}.getClass().getEnclosingMethod().getName() + "()#");
	    e.printStackTrace();
	    return null;
	}
	
    }

    public List<Employee> getEmoplyeesByCompany(String company)
    {
	
	try
	{
	    List <Employee> list ;
	    
	    session = factory.getCurrentSession();
	    session.beginTransaction();
	    
	    list= session.createQuery("from Employee where company='"+company+"'").getResultList();
	    
	    session.getTransaction().commit();
	    return list;
	    
	} 
	catch (Exception e)
	{
	    System.out.println("something went Wrong in method #" + new Object(){}.getClass().getEnclosingMethod().getName() + "()#");
	    e.printStackTrace();
	    return null;
	}
	
    }

    public int removeEmoplyee(int id )
    {
	try
	{
	    session = factory.getCurrentSession();
	    session.beginTransaction();

	    int res = session.createQuery("delete from Employee where id =" + id).executeUpdate();

	    session.getTransaction().commit();
	    return res;

	} catch (Exception e)
	{
	    System.out.println("something went Wrong in method #" + new Object(){}.getClass().getEnclosingMethod().getName() + "()#");
	    e.printStackTrace();
	    return 0;
	}
	
    }

    public void closeSessionFactory()
    {
	factory.close();
	System.out.println("Closed Session Factory");
    }

}

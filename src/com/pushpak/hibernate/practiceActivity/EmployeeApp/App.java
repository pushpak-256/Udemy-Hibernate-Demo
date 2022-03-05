package com.pushpak.hibernate.practiceActivity.EmployeeApp;

import java.util.List;

public class App
{

    public static void main(String[] args)
    {
	EmployeeOperations app = new EmployeeOperations();
	
	Employee emp;
	
	//1. add employee
	 emp = new Employee(1,"f","l", "com");
	app.addEmployee(emp);
	
	int id=2;
	
	//2. retrieve employee
	emp=app.getEmoplyee(id);
	if (emp != null)
	    System.out.println(emp);
	else
	    System.err.println("Employee not found with id " + id);
	
	//3 .delete employee
	if (app.removeEmoplyee(id) > 0)
	    System.out.println("deleted Emp with id "+id);
	else System.err.println("Emp not found with id "+id);
	
	// 4.query employee with company name
	String company = "com";
	List<Employee> list = app.getEmoplyeesByCompany(company);
	if (list.size()!=0)
	    System.out.println(list);
	else
	    System.err.println("No records found for company " + company);
	
	
	//closing factory 
	app.closeSessionFactory();
    }

}

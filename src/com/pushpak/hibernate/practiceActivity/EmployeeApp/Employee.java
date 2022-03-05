package com.pushpak.hibernate.practiceActivity.EmployeeApp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "company")
    private String company;

    public int getId()
    {
	return id;
    }

    public void setId(int id)
    {
	this.id = id;
    }

    public String getFirstName()
    {
	return firstName;
    }

    public void setFirstName(String firstName)
    {
	this.firstName = firstName;
    }

    public String getLastName()
    {
	return lastName;
    }

    public void setLastName(String lastName)
    {
	this.lastName = lastName;
    }

    public String getCompany()
    {
	return company;
    }

    public void setCompany(String company)
    {
	this.company = company;
    }

    @Override
    public String toString()
    {
	return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", company=" + company
		+ "]";
    }

    
    public Employee() {
    }

    public Employee(String firstName, String lastName, String company) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.company = company;
    }

    public Employee(int id, String firstName, String lastName, String company) {
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.company = company;
    }

}

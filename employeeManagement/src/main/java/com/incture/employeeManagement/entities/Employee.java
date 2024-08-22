package com.incture.employeeManagement.entities;

import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

//import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "employee")
public class Employee {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;
	    private Date dob;
	    private double salary;
	    private String contact;
	    private String email;
	    private String address;

	    @ManyToOne
	    @JoinColumn(name = "department_id")
//	    @JsonIgnore
	    private Department department;

	    @OneToOne
	    @JoinColumn(name = "project_id")
//	    @JsonIgnore
	    private Project project;
	    public Employee() {}
	    public Employee(String name, Date dob,double salary,String contact,String email,String address, Project project, Department department ) {
	    	this.name=name;
	    	this.dob=dob;
	    	this.salary=salary;
	    	this.contact=contact;
	    	this.email=email;
	    	this.address=address;
	    	this.project=project;
	    	this.department=department;
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Date getDob() {
			return dob;
		}

		public void setDob(Date dob) {
			this.dob = dob;
		}

		public double getSalary() {
			return salary;
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}

		public String getContact() {
			return contact;
		}

		public void setContact(String contact) {
			this.contact = contact;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public Department getDepartment() {
			return department;
		}

		public void setDepartment(Department department) {
			this.department = department;
		}

		public Project getProject() {
			return project;
		}

		public void setProject(Project project) {
			this.project = project;
		}
	    
}

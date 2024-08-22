package com.incture.employeeManagement.entities;

import jakarta.persistence.*;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Date startDate;
    private Date endDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="employee_id")
    @JsonIgnore
    
    private Employee employee;
    public Project() {}
    public Project(String title, String description, Date startDate, Date endDate, Employee employee) {
    	this.title = title;
    	this.description = description;
    	this.startDate = startDate;
    	this.endDate = endDate;
    	this.employee = employee;
    	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
   
}

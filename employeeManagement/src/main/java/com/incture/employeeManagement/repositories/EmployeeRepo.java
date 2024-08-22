package com.incture.employeeManagement.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.incture.employeeManagement.entities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}

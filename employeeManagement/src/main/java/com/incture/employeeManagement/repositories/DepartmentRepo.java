package com.incture.employeeManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.incture.employeeManagement.entities.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
}

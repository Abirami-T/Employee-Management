package com.incture.employeeManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.incture.employeeManagement.entities.Project;

public interface ProjectRepo extends JpaRepository<Project, Long> {
}

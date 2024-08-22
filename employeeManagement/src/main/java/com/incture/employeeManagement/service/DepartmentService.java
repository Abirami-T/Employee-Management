package com.incture.employeeManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incture.employeeManagement.entities.Department;
import com.incture.employeeManagement.repositories.DepartmentRepo;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepository;

    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }

    public Department updateDepartment(Long id, Department departmentDetails) {
        Department department = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
        department.setName(departmentDetails.getName());
        department.setTechnology(departmentDetails.getTechnology());
        department.setContact(departmentDetails.getContact());
        department.setAddress(departmentDetails.getAddress());
        return departmentRepository.save(department);
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}

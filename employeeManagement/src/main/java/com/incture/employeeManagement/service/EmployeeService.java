package com.incture.employeeManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incture.employeeManagement.entities.Department;
import com.incture.employeeManagement.entities.Employee;
import com.incture.employeeManagement.entities.Project;
import com.incture.employeeManagement.repositories.DepartmentRepo;
import com.incture.employeeManagement.repositories.EmployeeRepo;
import com.incture.employeeManagement.repositories.ProjectRepo;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService {
	 @Autowired
	    private EmployeeRepo employeeRepository;

	    @Autowired
	    private DepartmentRepo departmentRepository;

	    @Autowired
	    private ProjectRepo projectRepository;
	    @Transactional
	    public Employee addEmployee(Employee employee) {
	        Long departmentId = employee.getDepartment().getId();
	        Long projectId = employee.getProject().getId();

	        Department department = departmentRepository.findById(departmentId)
	                .orElseThrow(() -> new RuntimeException("Department not found with ID: " + departmentId));

	        Project project = projectRepository.findById(projectId)
	                .orElseThrow(() -> new RuntimeException("Project not found with ID: " + projectId));

	        employee.setDepartment(department);
	        employee.setProject(project);

	        return employeeRepository.save(employee);
	    }



	    @Transactional
	    public void deleteEmployee(Long id) {
	        employeeRepository.deleteById(id);
	    }

	    public List<Employee> getAllEmployees() {
	        return employeeRepository.findAll();
	    }

	    public Employee getEmployeeById(Long id) {
	        return employeeRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Employee not found"));
	    }

	    @Transactional
	    public Employee updateEmployee(Long employeeId, Employee employee) {
	        // Fetch the existing employee from the database
	        Employee existingEmployee = employeeRepository.findById(employeeId)
	                .orElseThrow(() -> new RuntimeException("Employee not found"));

	        // Ensure that the department and project exist before updating the employee
	        Department department = departmentRepository.findById(employee.getDepartment().getId())
	                .orElseThrow(() -> new RuntimeException("Department not found"));
	        Project project = projectRepository.findById(employee.getProject().getId())
	                .orElseThrow(() -> new RuntimeException("Project not found"));

	        // Set the updated values for the employee
	        existingEmployee.setName(employee.getName());
	        existingEmployee.setDob(employee.getDob());
	        existingEmployee.setSalary(employee.getSalary());
	        existingEmployee.setContact(employee.getContact());
	        existingEmployee.setEmail(employee.getEmail());
	        existingEmployee.setAddress(employee.getAddress());
	        existingEmployee.setDepartment(department);
	        existingEmployee.setProject(project);

	        // Save the updated employee
	        return employeeRepository.save(existingEmployee);
	    }
}

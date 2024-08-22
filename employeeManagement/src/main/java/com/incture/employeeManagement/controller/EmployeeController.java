package com.incture.employeeManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incture.employeeManagement.entities.Employee;
import com.incture.employeeManagement.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	 @Autowired
	    private EmployeeService employeeService;

	    @PostMapping
	    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
	        Employee savedEmployee = employeeService.addEmployee(employee);
	        return ResponseEntity.ok(savedEmployee);
	    }

	    @GetMapping
	    public List<Employee> getAllEmployees() {
	        return employeeService.getAllEmployees();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
	        Employee employee = employeeService.getEmployeeById(id);
	        return ResponseEntity.ok(employee);
	    }

	    @PutMapping("/{employeeId}")
	    public ResponseEntity<Employee> updateEmployee(@PathVariable Long employeeId, @RequestBody Employee employee) {
	        Employee updatedEmployee = employeeService.updateEmployee(employeeId, employee);
	        return ResponseEntity.ok(updatedEmployee);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
	        employeeService.deleteEmployee(id);
	        return ResponseEntity.ok("Employee deleted successfully");
	    }
}
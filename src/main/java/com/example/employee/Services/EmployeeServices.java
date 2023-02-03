package com.example.employee.Services;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.Models.Employee;
import com.example.employee.Repository.EmployeeRepo;
@Service
public class EmployeeServices {
	@Autowired
	EmployeeRepo employeeRepo;
	
	 
	public Employee addEmployee(Employee emp) {
		emp.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(emp);
	}
	
	public List<Employee> listEmployee() {
		return employeeRepo.findAll();
	}
	
	public Employee updateEmployee(Employee emp) {
		emp.setEmployeeCode(UUID.randomUUID().toString());
		 return employeeRepo.save(emp);
	}
	public void deleteEmployee(Long id) {
		employeeRepo.deleteById(id);
	}
	public Employee findEmployeeById(Long id) throws UserPrincipalNotFoundException {
		return employeeRepo.findEmployeeById(id);
	}
}
  
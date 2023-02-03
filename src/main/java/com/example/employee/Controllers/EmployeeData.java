package com.example.employee.Controllers;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.Models.Employee;
import com.example.employee.Services.EmployeeServices;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/employee")
public class EmployeeData {
	
	@Autowired
	EmployeeServices employeeServices;
	
	@GetMapping("allEmployees")
	public ResponseEntity<List<Employee>> getAllEmployee(){
       List<Employee> employee = employeeServices.listEmployee();
       return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@GetMapping("find/{id}")
	public ResponseEntity<Employee> getAllEmployees(@PathVariable("id") Long id) throws UserPrincipalNotFoundException{
       Employee employees = employeeServices.findEmployeeById(id);
       return new ResponseEntity<>(employees,HttpStatus.OK);

	}
	
	@DeleteMapping("delete/{id}")
	public void deleteEmployee(@PathVariable("id") Long id){
       employeeServices.deleteEmployee(id);  
	}
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		System.out.println(employee);
       employee = employeeServices.addEmployee(employee);
       return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@PutMapping("/update")
    public ResponseEntity<Employee>  updateEmployee(@RequestBody Employee employee){
      employee = employeeServices.updateEmployee(employee);
      return new ResponseEntity<>(employee,HttpStatus.CREATED);
	}
	

}

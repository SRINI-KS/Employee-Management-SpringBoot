package com.example.employee.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee.Models.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	


	Employee findEmployeeById(Long id);


}

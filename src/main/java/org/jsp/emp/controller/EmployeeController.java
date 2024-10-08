package org.jsp.emp.controller;

import java.util.List;

import org.jsp.emp.entity.Employee;
import org.jsp.emp.responsestructure.ResponseStructure;
import org.jsp.emp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@PostMapping
	public ResponseStructure<Employee> saveEmployee(@RequestBody Employee employee){
		return service.saveEmployee(employee);
	}

	@PutMapping
	public ResponseStructure<Employee> updateEmployee(@RequestBody Employee employee){
		return service.updateEmployee(employee);
	}
	
	@GetMapping("/{id}")
	public ResponseStructure<Employee> findEmployeeById(@PathVariable int id){
		return service.findEmployeeById(id);
	}
	
	@GetMapping
	public ResponseStructure<List<Employee>> findAllEmployee(){
		return service.findAllEmployee();
	}
	
	@DeleteMapping("/{id}")
	public ResponseStructure<String> deleteEmployeeById(@PathVariable int id){
		return service.deleteEmployeeById(id);
	}
	
	@GetMapping("/{email}/{password}")
	public ResponseStructure<Employee> findEmployeeByEmailAndPassword(@PathVariable String email,@PathVariable String password){
		return service.findEmployeeByEmailAndPassword(email, password);
	}
	
	@GetMapping("/name/{name}")
	public ResponseStructure<List<Employee>> findEmployeeByName(@PathVariable String name){
		return service.findEmployeeByName(name);
	}
	
	@PatchMapping("/active/{id}")
	public ResponseStructure<Employee> setEmployeeStatusActive(@PathVariable int id){
		return service.setEmployeeStatusActive(id);
	}
	
	@PatchMapping("/inactive/{id}")
	public ResponseStructure<Employee> setEmployeeStatusInActive(@PathVariable int id){
		return service.setEmployeeStatusInActive(id);
	}
}

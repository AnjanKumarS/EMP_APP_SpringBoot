package org.jsp.emp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.emp.entity.Employee;
import org.jsp.emp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDAO {
	
	@Autowired
	private EmployeeRepository repository;
	
	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}
	
	public Employee updateEmployee(Employee employee) {
		return repository.save(employee);
	}
	
	public Optional<Employee> findEmployeeById(int id){
		return repository.findById(id);
	}
	
	public List<Employee> findAllEmployee(){
		return repository.findAll();
	}
	
	public List<Employee> findAllActiveEmployee(){
		return repository.findAllActiveEmployee();
	}
	
	public void deleteEmployeeById(int id) {
		repository.deleteById(id);
	}
	
	public Optional<Employee> findEmployeeByEmailAndPassword(String email, String password){
		return repository.findEmployeeByEmailAndPassword(email,password);
	}
	
	public List<Employee> findEmployeeByName(String name){
		return repository.findEmployeeByName(name);
	}
}

package org.jsp.emp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.emp.EmployeeStatus;
import org.jsp.emp.dao.EmployeeDAO;
import org.jsp.emp.entity.Employee;
import org.jsp.emp.exceptionclass.InvalidCredentialException;
import org.jsp.emp.exceptionclass.InvalidEmployeeIdException;
import org.jsp.emp.exceptionclass.NoActiveEmployeeFoundException;
import org.jsp.emp.exceptionclass.NoEmployeeFoundException;
import org.jsp.emp.responsestructure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {
	
	@Autowired
	private EmployeeDAO dao;
	
	public ResponseStructure<Employee> saveEmployee(Employee employee){
		employee.setStatus(EmployeeStatus.IN_ACTIVE);
		employee = dao.saveEmployee(employee);
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setMessage("Employee Saved Sucessfully...");
		structure.setBody(employee);
		return structure;
	}
	
	public ResponseStructure<Employee> updateEmployee(Employee employee){
		employee = dao.saveEmployee(employee);
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("Employee Updated Sucessfully...");
		structure.setBody(employee);
		return structure;
	}
	
	public ResponseStructure<Employee> findEmployeeById(int id){
		Optional<Employee> op = dao.findEmployeeById(id);
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		if(op.isEmpty()) {
			throw new InvalidEmployeeIdException("Invalid Employee Id");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
//			structure.setMessage("Invalid Employee ID...");
//			structure.setBody(null);
//			return structure;
		}
		Employee e = op.get();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("Employee found sucessfully...");
		structure.setBody(e);
		return structure;
	}
	
	public ResponseStructure<List<Employee>> findAllEmployee(){
		List<Employee> op = dao.findAllActiveEmployee();
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		if(op.isEmpty()) {
			throw new NoActiveEmployeeFoundException("No Active Employee Present in the DataBase");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
//			structure.setMessage("Invalid Employee ID...");
//			structure.setBody(null);
//			return structure;
		}
//		ArrayList<Employee> activeEmployee = new ArrayList<>();
//		for(Employee e : op) {
//			if(e.getStatus()==EmployeeStatus.ACTIVE)
//				activeEmployee.add(e);
//		}
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setMessage("Employee found sucessfully...");
		structure.setBody(op);
		return structure;
	}
	
	public ResponseStructure<String> deleteEmployeeById(int id){
		Optional<Employee> op = dao.findEmployeeById(id);
		ResponseStructure<String> structure = new ResponseStructure<>();
		if(op.isEmpty()) {
			throw new InvalidEmployeeIdException("Invalid Employee Id Unable to delete");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
//			structure.setMessage("Invalid Employee ID...");
//			structure.setBody("Unable to delete Employee id");
//			return structure;
		}
		dao.deleteEmployeeById(id);
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("Valid Employee ID...");
		structure.setBody("Employee Deleted Sucessfully...");
		return structure;
	}
	
	public ResponseStructure<Employee> findEmployeeByEmailAndPassword(String email,String password){
		Optional<Employee> op = dao.findEmployeeByEmailAndPassword(email, password);
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		if(op.isEmpty()) {
			throw new InvalidCredentialException("Invalid Email or Password...");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
//			structure.setMessage("Invalid Employee email and Password...");
//			structure.setBody(null);
//			return structure;
		}
		Employee e = op.get();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("Employee Found Sucessfully ID...");
		structure.setBody(e);
		return structure;

	}
	
	public ResponseStructure<List<Employee>> findEmployeeByName(String name){
		List<Employee> op = dao.findEmployeeByName(name);
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		if(op.isEmpty()) {
			throw new NoEmployeeFoundException("No Matching Employees found for the Requested name...");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
//			structure.setMessage("Invalid Employee Name...");
//			structure.setBody(null);
//			return structure;
		}
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("Employee found sucessfully...");
		structure.setBody(op);
		return structure;
	}

	public ResponseStructure<Employee> setEmployeeStatusActive(int id) {
		Optional<Employee> optional = dao.findEmployeeById(id);
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		if(optional.isEmpty()) {
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMessage("Invalid employee id");
			structure.setBody(null);
			return structure;
		}
		Employee e = optional.get();
		e.setStatus(EmployeeStatus.ACTIVE);
		e = dao.updateEmployee(e);
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("Employee updated to Active");
		structure.setBody(e);
		return structure;
	}

	public ResponseStructure<Employee> setEmployeeStatusInActive(int id) {
		Optional<Employee> optional = dao.findEmployeeById(id);
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		if(optional.isEmpty()) {
			throw new InvalidEmployeeIdException("Unable to set Status IN_ACTIVE");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
//			structure.setMessage("Invalid employee id");
//			structure.setBody(null);
//			return structure;
		}
		Employee e = optional.get();
		e.setStatus(EmployeeStatus.IN_ACTIVE);
		e=dao.updateEmployee(e);
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("Employee updated to InActive");
		structure.setBody(e);
		return structure;
	}
}
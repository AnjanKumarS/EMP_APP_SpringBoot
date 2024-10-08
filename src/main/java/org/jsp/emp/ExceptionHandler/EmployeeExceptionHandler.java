package org.jsp.emp.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;

import org.jsp.emp.exceptionclass.InvalidCredentialException;
import org.jsp.emp.exceptionclass.InvalidEmployeeIdException;
import org.jsp.emp.exceptionclass.NoActiveEmployeeFoundException;
import org.jsp.emp.exceptionclass.NoEmployeeFoundException;
import org.jsp.emp.responsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeExceptionHandler {
	
	@ExceptionHandler(NoActiveEmployeeFoundException.class)
	public ResponseEntity<ResponseStructure<String>> noActiveEmployeeFoundExceptionHandler(NoActiveEmployeeFoundException e) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("No Active Employee Found");
		structure.setBody(e.getMessage());
		return new ResponseEntity(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidEmployeeIdException.class)
	public ResponseEntity<ResponseStructure<String>> invalidEmployeeIdExceptionHandler(InvalidEmployeeIdException e) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Invalid Employee Id");
		structure.setBody(e.getMessage());
		return new ResponseEntity(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidCredentialException.class)
	public ResponseEntity<ResponseStructure<String>> invalidCredentialException(InvalidCredentialException e) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Invalid Employee Id");
		structure.setBody(e.getMessage());
		return new ResponseEntity(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoEmployeeFoundException.class)
	public ResponseEntity<ResponseStructure<String>> noEmployeeFoundException(NoEmployeeFoundException e){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("No Employee Found");
		structure.setBody(e.getMessage());
		return new ResponseEntity(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ResponseStructure<String>> sqlIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setMessage("Invalid Email Id");
		structure.setBody(e.getMessage());
		return new ResponseEntity(structure,HttpStatus.BAD_REQUEST);
	}
}

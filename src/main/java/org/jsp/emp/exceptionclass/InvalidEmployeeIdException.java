package org.jsp.emp.exceptionclass;

public class InvalidEmployeeIdException extends RuntimeException{
	private String message;
	
	public InvalidEmployeeIdException(String message) {
		this.message=message;
	}
	
	public InvalidEmployeeIdException() {

	}
	
	@Override
	public String getMessage() {
		return this.getMessage();
	}
}

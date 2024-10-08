package org.jsp.emp.exceptionclass;

public class NoActiveEmployeeFoundException extends RuntimeException {
	private String message;
	
	public NoActiveEmployeeFoundException(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return this.getMessage();
	}
}

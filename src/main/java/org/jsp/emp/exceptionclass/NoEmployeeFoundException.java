package org.jsp.emp.exceptionclass;

public class NoEmployeeFoundException extends RuntimeException {

	private String message;
	
	public NoEmployeeFoundException() {
		
	}
	
	public NoEmployeeFoundException(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return this.getMessage();
	}
}

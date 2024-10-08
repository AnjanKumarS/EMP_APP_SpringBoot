package org.jsp.emp.exceptionclass;

public class InvalidCredentialException extends RuntimeException {
	private String message;
	
	public InvalidCredentialException(String message) {
		this.message=message;
	}
	
	public InvalidCredentialException() {
	
	}
	
	@Override
	public String getMessage() {
		return this.getMessage();
	}
}

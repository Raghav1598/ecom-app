package com.project.ecom.error;

public class ErrorMessage {
	
	private String message;
	
	public ErrorMessage(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ErrorMessage [message=" + message + "]";
	}
	
}

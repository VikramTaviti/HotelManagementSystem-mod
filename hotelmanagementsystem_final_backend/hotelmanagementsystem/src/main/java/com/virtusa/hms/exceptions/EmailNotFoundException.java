package com.virtusa.hms.exceptions;

public class EmailNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EmailNotFoundException(String message) {
		super(message);
	}
}

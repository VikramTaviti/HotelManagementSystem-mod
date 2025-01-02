package com.virtusa.hms.exceptions;

public class JwtTokenExpiredException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JwtTokenExpiredException(String message) {
		super(message);
	}
	
}

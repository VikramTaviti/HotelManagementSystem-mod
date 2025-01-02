package com.virtusa.hms.utility;

import org.springframework.stereotype.Component;

@Component
public class Message {
	
	String message;
	
	public Message(String message) {
		super();
		this.message = message;
	}
	
	public Message() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
}

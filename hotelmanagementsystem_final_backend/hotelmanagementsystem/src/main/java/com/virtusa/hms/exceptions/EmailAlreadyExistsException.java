package com.virtusa.hms.exceptions;

public class EmailAlreadyExistsException extends RuntimeException {
    private static final long serialVersionUID = 1L;  // Unique identifier for serialization

    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}

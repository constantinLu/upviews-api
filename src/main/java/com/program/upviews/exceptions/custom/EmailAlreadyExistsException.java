package com.program.upviews.exceptions.custom;

public class EmailAlreadyExistsException extends RuntimeException {
    private static final String  MESSAGE = "Email already exists ";

    public EmailAlreadyExistsException(String msg) {
        super(MESSAGE + msg);
    }
}


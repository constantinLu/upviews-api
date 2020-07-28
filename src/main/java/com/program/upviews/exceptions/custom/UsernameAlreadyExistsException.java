package com.program.upviews.exceptions.custom;

public class UsernameAlreadyExistsException extends RuntimeException {
    private static final String  MESSAGE = "Username already exists ";

    public UsernameAlreadyExistsException(String msg) {
        super(MESSAGE + msg);
    }
}
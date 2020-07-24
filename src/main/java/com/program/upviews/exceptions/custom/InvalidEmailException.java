package com.program.upviews.exceptions.custom;

public class InvalidEmailException extends RuntimeException {
    private static final String  MESSAGE = "Invalid email ";

    public InvalidEmailException(String msg) {
        super(MESSAGE + msg);
    }
}
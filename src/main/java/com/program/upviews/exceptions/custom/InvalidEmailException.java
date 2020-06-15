package com.program.upviews.exceptions.custom;

public class InvalidEmailException extends RuntimeException {
    private static final String  message = "Invalid email ";

    public InvalidEmailException(String msg) {
        super(message + msg);
    }
}
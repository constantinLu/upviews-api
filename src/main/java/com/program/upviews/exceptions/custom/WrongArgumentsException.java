package com.program.upviews.exceptions.custom;

public class WrongArgumentsException extends RuntimeException {

    private static final String MESSAGE = "Wrong arguments. ";

    public WrongArgumentsException(String details) {
        super(MESSAGE + details);
    }
}

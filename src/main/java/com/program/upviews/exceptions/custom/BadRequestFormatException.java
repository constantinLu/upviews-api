package com.program.upviews.exceptions.custom;

public class BadRequestFormatException extends RuntimeException {

    private static final String MESSAGE = "Bad request.";

    public BadRequestFormatException() {
        super(MESSAGE);
    }
}

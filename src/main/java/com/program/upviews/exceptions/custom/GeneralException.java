package com.program.upviews.exceptions.custom;

public class GeneralException extends RuntimeException {

    private static final String MESSAGE = "General exception.";

    public GeneralException() {
        super(MESSAGE);
    }
}

package com.program.upviews.exceptions.custom;

public class EmptyDateExeption extends RuntimeException {

    private static final String MESSAGE = "Empty date.";

    public EmptyDateExeption() {
        super(MESSAGE);
    }
}

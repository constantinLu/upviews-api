package com.program.upviews.exceptions.custom;

public class DataNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Data not found for ";

    public DataNotFoundException(String dataDetails) {
        super(MESSAGE + dataDetails);
    }
}

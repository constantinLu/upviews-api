package com.program.upviews.exceptions.custom;

public class DataAlreadyExistsException extends RuntimeException {

    private static final String MESSAGE = "Data already exists for ";

    public DataAlreadyExistsException(String dataDetails) {
        super(MESSAGE + dataDetails);
    }
}

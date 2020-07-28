package com.program.upviews.exceptions.custom;

public class PasswordMisMatchException extends RuntimeException {

    private static final String  MESSAGE = "New password is not matching for current user: ";

    public PasswordMisMatchException(String msg) {
        super(MESSAGE + msg);
    }
}

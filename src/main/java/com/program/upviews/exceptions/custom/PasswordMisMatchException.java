package com.program.upviews.exceptions.custom;

public class PasswordMisMatchException extends RuntimeException {

    private static final String  message = "New password is not matching for current user: ";

    public PasswordMisMatchException(String msg) {
        super(message + msg);
    }
}

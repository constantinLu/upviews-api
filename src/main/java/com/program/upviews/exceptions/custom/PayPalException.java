package com.program.upviews.exceptions.custom;

public class PayPalException extends RuntimeException {

    private static final String MESSAGE = "Paypal payment: ";

    public PayPalException() {
        super(MESSAGE);
    }

    public PayPalException(String details) {
        super(MESSAGE);
    }
}

package com.program.upviews.paypal.util;

/*
This are the supported values for sending the payment in the intent field for the requestPayment
 */
public enum PaypalIntent {

    SALE,
    AUTHORIZE,
    ORDER,
    NONE
}

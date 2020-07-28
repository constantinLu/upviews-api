package com.program.upviews.paypal.service;

import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

public interface PaypalService {

    /**
     * @param total       amount of money
     * @param currency    dollar/euros etc.
     * @param method      of payment (paypal, credit,card crypto)
     * @param intent      -
     * @param description some description
     * @param cancelUrl   redirect if the payment failed
     * @param successUrl  redirect if the payment is successfully
     * @return a paypal payment for future processing.
     */
    String processPayment(Double total, String currency, String method, String intent,
                          String description, String cancelUrl, String successUrl);


    /**
     * @param paymentId id of the payment
     * @param payerId   id of the user
     * @return payment
     */
    Payment executePayment(String paymentId, String payerId);
}

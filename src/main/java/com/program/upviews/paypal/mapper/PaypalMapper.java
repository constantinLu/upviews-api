package com.program.upviews.paypal.mapper;

import com.paypal.api.payments.*;
import java.util.List;
import org.springframework.stereotype.Component;

public class PaypalMapper {

    public static Payment mapPayment(String intent, String cancelUrl, String successUrl, List<Transaction> transactions, Payer payer) {
        Payment payment = new Payment();
        payment.setIntent(intent);
        payment.setPayer(payer);
        payment.setTransactions(transactions);
        payment.setRedirectUrls(mapRedirectUrls(cancelUrl, successUrl));
        return payment;
    }

    public static RedirectUrls mapRedirectUrls(String cancelUrl, String successUrl) {
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl(cancelUrl);
        redirectUrls.setReturnUrl(successUrl);
        return redirectUrls;
    }

    public static Transaction mapTransaction(String description, Amount amount) {
        Transaction transaction = new Transaction();
        transaction.setDescription(description);
        transaction.setAmount(amount);
        return transaction;
    }
}

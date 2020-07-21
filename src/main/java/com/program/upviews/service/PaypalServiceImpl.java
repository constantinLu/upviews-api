package com.program.upviews.service;

import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import com.program.upviews.exceptions.custom.DataNotFoundException;
import static com.program.upviews.util.Url.CANCEL_URL;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaypalServiceImpl implements PaypalService {

    private final APIContext apiContext;

    public PaypalServiceImpl(APIContext apiContext) {
        this.apiContext = apiContext;
    }

    @Override
    public Payment createPayment(Double total, String currency, String method, String intent,
                                 String description, String cancelUrl, String successUrl) throws PayPalRESTException {
        Amount amount = new Amount();
        amount.setCurrency(currency);
        total = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP).doubleValue();
        amount.setTotal(String.format("%.2f", total));


        Transaction transaction = new Transaction();
        transaction.setDescription(description);
        transaction.setAmount(amount);

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);

        Payer payer = new Payer();
        payer.setPaymentMethod(method);

        Payment payment = new Payment();
        payment.setIntent(intent);
        payment.setPayer(payer);
        payment.setTransactions(transactions);
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl(cancelUrl);
        redirectUrls.setReturnUrl(successUrl);
        payment.setRedirectUrls(redirectUrls);

        return payment.create(apiContext);
    }

    public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException {
        Payment payment = new Payment();
        payment.setId(paymentId);
        PaymentExecution paymentExecute = new PaymentExecution();
        paymentExecute.setPayerId(payerId);
        return payment.execute(apiContext, paymentExecute);
    }

    @Override
    public String purchase(Double total, String currency, String method, String intent, String description, String cancelUrl, String successUrl) throws PayPalRESTException {
        try {
            Payment payment = createPayment(total, currency, method,
                    intent, description, cancelUrl(), succesUrl());
            for (Links link : payment.getLinks()) {
                if (link.getRel().equals("approval_url")) {
                    return link.getHref();
                }
            }
        } catch (PayPalRESTException e) {
            e.printStackTrace();
            throw new DataNotFoundException("Paymen cannot be made");

        }
        return "/purchase";
    }

    @Override
    public String successPay(String paymentId, String payerId) {
        try {
            Payment payment = executePayment(paymentId, paymentId);
            System.out.println(payment.toJSON());
            if (payment.getState().equals("approved")) {
                return succesUrl();
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        return null;
    }

    private String cancelUrl() {
        return CANCEL_URL;
    }

    private String succesUrl() {
        return "/succes";
    }
}

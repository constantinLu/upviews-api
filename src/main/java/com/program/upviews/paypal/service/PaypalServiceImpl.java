package com.program.upviews.paypal.service;

import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import static com.program.upviews.common.Commons.PAYPAL_APPROVED;
import com.program.upviews.exceptions.custom.PayPalException;
import static com.program.upviews.paypal.mapper.PaypalMapper.mapPayment;
import static com.program.upviews.paypal.mapper.PaypalMapper.mapTransaction;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

//FIXME: THIS FOR TESTING PURPOSES / WILL BE MODIFIED FOR OUR FROND END IN THE FUTURE.
@Service
@Slf4j
public class PaypalServiceImpl implements PaypalService {

    private APIContext apiContext;

    public PaypalServiceImpl(APIContext apiContext) {
        this.apiContext = apiContext;
    }

    /**
     * @param total       amount of money
     * @param currency    dollar/euros etc.
     * @param method      of payment (paypal, credit,card crypto)
     * @param intent      -
     * @param description some description
     * @param cancelUrl   redirect if the payment failed
     * @param successUrl  redirect if the payment is successfully
     * @return return the redirect linked to the paypal portal
     */
    public String processPayment(Double total, String currency, String method, String intent, String description, String cancelUrl, String successUrl) {
        Optional<Links> processedLink;
        try {
            Payment payment = createPayments(total, currency, method, intent, description, cancelUrl, successUrl);
            processedLink = (payment.getLinks()
                    .stream().filter(link -> link.getRel().equals(PAYPAL_APPROVED)).findFirst());   //return "redirect:"+link.getHref();
        } catch (PayPalRESTException e) {
            e.printStackTrace();
            throw new PayPalException("could not be processed");
        }
        return processedLink.get().getHref();
    }


    private Payment createPayments(Double total, String currency, String method, String intent, String description, String cancelUrl, String successUrl) throws PayPalRESTException {

        Amount amount = new Amount(currency, String.format("%.2f", new BigDecimal(total).setScale(2, RoundingMode.HALF_UP).doubleValue()));
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(mapTransaction(description, amount));
        Payer payer = new Payer();
        payer.setPaymentMethod(method);
        Payment payment = mapPayment(intent, cancelUrl, successUrl, transactions, payer);

        return payment.create(apiContext);
    }


    public Payment executePayment(String paymentId, String payerId) {
        Payment processedPayment = null;
        try {
            Payment payment = new Payment();
            payment.setId(paymentId);
            PaymentExecution paymentExecute = new PaymentExecution();
            paymentExecute.setPayerId(payerId);
            processedPayment = payment.execute(apiContext, paymentExecute);
        } catch (PayPalRESTException e) {
            throw new PayPalException("could not be executed");
        }
        return processedPayment;
    }
}

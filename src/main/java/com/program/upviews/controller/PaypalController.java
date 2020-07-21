package com.program.upviews.controller;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import com.program.upviews.exceptions.custom.DataNotFoundException;
import com.program.upviews.requests.PaymentRequest;
import com.program.upviews.response.PaymentResponse;
import com.program.upviews.service.PaypalService;
import static com.program.upviews.util.Api.PREFIX_URL;
import static com.program.upviews.util.Url.CANCEL_URL;
import static com.program.upviews.util.Url.SUCCESS_URL;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping(PREFIX_URL)
public class PaypalController {

    PaypalService paypalService;

    public PaypalController(PaypalService paypalService) {
        this.paypalService = paypalService;
    }

    @ApiOperation(value = "Make a purchase", notes = "Saves the project for the selected resume")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = PaymentResponse.class),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 401, message = "Not authenticated"),
            @ApiResponse(code = 403, message = "Not authorized to save project"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @PostMapping("/purchase")
    public String createProject(@RequestBody PaymentRequest request) {
        try {
            Payment payment = paypalService.createPayment(request.getPrice(), request.getCurrency(), request.getMethod(),
                    request.getIntent(), request.getDescription(), CANCEL_URL, SUCCESS_URL);
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

    @GetMapping("/purchase")
    public String createProject(@RequestParam("paymentId") String paymentId, @RequestParam("payerId") String payerId) {
        return paypalService.successPay(paymentId, payerId);
    }
}

package com.program.upviews.controller;

import com.paypal.api.payments.Payment;
import com.program.upviews.paypal.service.PaypalService;
import com.program.upviews.requests.PaypalPaymentRequest;
import com.program.upviews.response.PaypalPaymentResponse;
import static com.program.upviews.util.Api.PREFIX_URL;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

//FIXME: THIS FOR TESTING PURPOSES / WILL BE MODIFIED FOR OUR FRONT END IN THE FUTURE.
@RestController
@CrossOrigin
@RequestMapping(PREFIX_URL)
public class PaypalController {

    public static final String SUCCESS_URL = "http://localhost:8090/pay/success";
    public static final String CANCEL_URL = "http://localhost:8090/pay/cancel";
    private PaypalService paypalService;

    public PaypalController(PaypalService paypalService) {
        this.paypalService = paypalService;
    }


    @ApiOperation(value = "Make a purchase", notes = "Saves the project for the selected resume")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = PaypalPaymentResponse.class),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 401, message = "Not authenticated"),
            @ApiResponse(code = 403, message = "Not authorized to save project"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @PostMapping("/payment")
    public PaypalPaymentResponse processPayment(@RequestBody PaypalPaymentRequest request) {
        return new PaypalPaymentResponse(
                paypalService.processPayment(request.getPrice(), request.getCurrency(), request.getMethod(),
                        request.getIntent(), request.getDescription(),
                        CANCEL_URL, SUCCESS_URL));

    }


    @GetMapping("/")
    public String home() {
        return "home";
    }


    @GetMapping(value = SUCCESS_URL)
    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
        Payment payment = paypalService.executePayment(paymentId, payerId);
        System.out.println(payment.toJSON());
        if (payment.getState().equals("approved")) {
            return "success";
        }
        return "redirect:/";
    }


    @GetMapping(value = CANCEL_URL)
    public String cancelPay() {
        return "cancel";
    }
}

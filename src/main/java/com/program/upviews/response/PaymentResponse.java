package com.program.upviews.response;


import com.paypal.api.payments.Payment;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentResponse {

    String redirectUrl;
}

package com.program.upviews.requests;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaypalPaymentRequest {

    private double price;
    private String currency;
    private String method;
    private String intent;
    private String description;
}

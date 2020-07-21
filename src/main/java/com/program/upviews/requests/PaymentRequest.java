package com.program.upviews.requests;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {

    private double price;
    private String currency;
    private String method;
    private String intent;
    private String description;
}

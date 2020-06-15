package com.program.upviews.dto;

import com.program.upviews.common.Payment;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDto {

    private String id;

    private Payment payment;
}

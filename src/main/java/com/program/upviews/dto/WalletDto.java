package com.program.upviews.dto;

import java.math.BigDecimal;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WalletDto {

    private String id;

    private BigDecimal balance;


}

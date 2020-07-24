package com.program.upviews.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WalletTransactionDto {

    private String id;

    private BigDecimal amount;

    private LocalDateTime depositDate;
}

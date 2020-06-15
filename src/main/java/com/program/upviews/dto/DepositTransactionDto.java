package com.program.upviews.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepositTransactionDto {

    private String id;

    private BigDecimal amount;

    private LocalDateTime depositDate;
}

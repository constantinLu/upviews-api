package com.program.upviews.entity;

import com.program.upviews.common.Payment;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "DEPOSIT_TRANSACTION")
public class DepositTransactionEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    private LocalDateTime depositDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private PaymentEntity payment;

}

package com.program.upviews.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "WALLET")
public class WalletEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal balance;

    @OneToOne(fetch = FetchType.EAGER)
    private AccountEntity account;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private DepositTransactionEntity depositTransaction;

}

package com.program.upviews.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ORDER_")
public class OrderEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderDate;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ProductEntity product;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private PaymentEntity payment;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private StatusEntity status;

}

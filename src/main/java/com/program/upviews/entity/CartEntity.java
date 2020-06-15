package com.program.upviews.entity;

import com.program.upviews.common.CartType;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "CART")
public class CartEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private CartType type;

    private LocalDateTime cartOrderDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<OrderEntity> orders;

}

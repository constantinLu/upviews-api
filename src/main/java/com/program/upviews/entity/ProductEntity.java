package com.program.upviews.entity;

import com.program.upviews.common.Category;
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
@Table(name = "PRODUCT")
public class ProductEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal price;

    private BigDecimal discount;

    @ManyToOne(fetch = FetchType.LAZY)
    private CategoryEntity category;

    private String description;

}

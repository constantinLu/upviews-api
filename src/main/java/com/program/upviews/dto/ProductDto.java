package com.program.upviews.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    private String id;

    private String name;

    private BigDecimal price;

    private BigDecimal discount;

    private String description;
}

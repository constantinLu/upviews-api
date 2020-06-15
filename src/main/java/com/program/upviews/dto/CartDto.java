package com.program.upviews.dto;

import com.program.upviews.common.CartType;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDto {

    private String id;

    private CartType type;

    private LocalDateTime cartOrderDate;
}

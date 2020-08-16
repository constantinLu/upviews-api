package com.program.upviews.response;


import com.program.upviews.dto.ProductDto;
import java.util.List;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {

    List<ProductDto> products;
}

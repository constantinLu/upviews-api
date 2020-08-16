package com.program.upviews.service;

import com.program.upviews.dto.ProductDto;
import java.util.List;

public interface ProductService {

    /**
     * reads all products from the database
     * @return list of product dtos
     */
    List<ProductDto> readProducts();


}

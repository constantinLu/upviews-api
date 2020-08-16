package com.program.upviews.service;

import static com.google.common.collect.Lists.newArrayList;
import com.program.upviews.dto.ProductDto;
import com.program.upviews.entity.ProductEntity;
import com.program.upviews.eresume.util.EncryptUtil;
import com.program.upviews.repository.ProductRepository;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ModelMapper modelMapper;

    private final EncryptUtil encryptUtil;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, EncryptUtil encryptUtil) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.encryptUtil = encryptUtil;
    }

    @Override
    public List<ProductDto> readProducts() {

        List<ProductDto> productDtos = newArrayList();
        Iterable<ProductEntity> productEntities = productRepository.findAll();
        productEntities.forEach(productEntity -> {
            ProductDto productDto = modelMapper.map(productEntity, ProductDto.class);
            productDto.setId(encryptUtil.encrypt(productEntity.getId()));
            productDtos.add(productDto);
        });

        return productDtos;
    }
}

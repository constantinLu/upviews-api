package com.program.upviews.repository;

import com.program.upviews.entity.AccountEntity;
import com.program.upviews.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

    ProductEntity findByName(String name);
}

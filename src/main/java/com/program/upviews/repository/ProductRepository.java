package com.program.upviews.repository;

import com.program.upviews.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

    ProductEntity findByName(String name);

}

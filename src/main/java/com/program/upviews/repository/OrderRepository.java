package com.program.upviews.repository;

import com.program.upviews.entity.AccountEntity;
import com.program.upviews.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {

    OrderEntity findByOrderDate(String email);
}

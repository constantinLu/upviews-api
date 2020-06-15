package com.program.upviews.repository;

import com.program.upviews.common.Payment;
import com.program.upviews.entity.PaymentEntity;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<PaymentEntity, Long> {

    PaymentEntity findByPaymentType(Payment payment);
}

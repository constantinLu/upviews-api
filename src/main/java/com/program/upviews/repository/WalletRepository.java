package com.program.upviews.repository;

import com.program.upviews.entity.WalletEntity;
import org.springframework.data.repository.CrudRepository;

public interface WalletRepository extends CrudRepository<WalletEntity, Long> {

    WalletEntity findByAccountId(Long id);
}

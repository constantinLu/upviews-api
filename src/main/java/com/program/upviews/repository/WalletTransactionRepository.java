package com.program.upviews.repository;

import com.program.upviews.entity.WalletTransactionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletTransactionRepository extends CrudRepository<WalletTransactionEntity, Long> {

}

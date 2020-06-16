package com.program.upviews.repository;

import com.program.upviews.entity.WalletTransactionEntity;
import org.springframework.data.repository.CrudRepository;

public interface DepositTransactionRepository extends CrudRepository<WalletTransactionEntity, Long> {

//    @Query("SELECT d FROM DatabaseEntity d WHERE LOWER(d.dbName) LIKE CONCAT(LOWER(:partialName),'%') ORDER BY d.dbName")
//    List<Optional<WalletTransactionEntity>> readDatabases(@Param("partialName") String partialName);
//
//    Optional<WalletTransactionEntity> findByDbName(String dbName);
}

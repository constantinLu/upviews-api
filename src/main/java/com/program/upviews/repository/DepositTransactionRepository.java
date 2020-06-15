package com.program.upviews.repository;

import com.program.upviews.entity.DepositTransactionEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DepositTransactionRepository extends CrudRepository<DepositTransactionEntity, Long> {

//    @Query("SELECT d FROM DatabaseEntity d WHERE LOWER(d.dbName) LIKE CONCAT(LOWER(:partialName),'%') ORDER BY d.dbName")
//    List<Optional<DepositTransactionEntity>> readDatabases(@Param("partialName") String partialName);
//
//    Optional<DepositTransactionEntity> findByDbName(String dbName);
}

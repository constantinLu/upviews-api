package com.program.upviews.repository;

import com.program.upviews.entity.AccountEntity;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AccountEntity, Long> {

    Optional<AccountEntity> findByEmail(String email);
}

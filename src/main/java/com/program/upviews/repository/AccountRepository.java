package com.program.upviews.repository;

import com.program.upviews.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AccountEntity, Long> {

    AccountEntity findByEmail(String email);

}

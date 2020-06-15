package com.program.upviews.repository;

import com.program.upviews.common.Status;
import com.program.upviews.entity.StatusEntity;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends CrudRepository<StatusEntity, Long> {

    StatusEntity findByStatus(Status role);
}

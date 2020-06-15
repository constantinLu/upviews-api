package com.program.upviews.repository;

import com.program.upviews.common.Role;
import com.program.upviews.entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<RoleEntity, Long> {

    RoleEntity findByRole(Role role);
}

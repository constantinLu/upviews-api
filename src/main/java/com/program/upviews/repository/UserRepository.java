package com.program.upviews.repository;

import com.program.upviews.entity.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByUserName(String username);

    Optional<UserEntity> findByResetToken(String resetToken);

    Optional<UserEntity> findUserEntityByAccountEmail(@Param("email") String email);

    @Transactional
    @Modifying
    @Query("update UserEntity u set u.password = :password where u.userName = :username")
    void updatePassword(@Param("password") String password, @Param("username") String username);

    @Transactional
    @Modifying
    @Query("update UserEntity u set u.password = :password where u.resetToken = :resetToken")
    void resetPassword(@Param("password") String password, @Param("resetToken") String resetToken);

}


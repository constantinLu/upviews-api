package com.program.upviews.repository;

import com.program.upviews.entity.CartEntity;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<CartEntity, Long> {

//    List<Optional<CartEntity>> findByResumeEntityIdOrderByIssueDateDesc(Long resumeId);
//
//    @Transactional
//    @Modifying
//    @Query("UPDATE CertificationEntity c SET c.issuingOrganisation=:issuingOrganisation, c.certificateName=:certificateName, " +
//            "c.issueDate=:issueDate, c.expirationDate=:expirationDate WHERE c.clientId =:certificationId AND c.resumeEntity.clientId=:resumeId")
//    int updateCertification(@Param("issuingOrganisation") String issuingOrganisation,
//                            @Param("certificateName") String certificateName,
//                            @Param("issueDate") LocalDate issueDate,
//                            @Param("expirationDate") LocalDate expirationDate,
//                            @Param("certificationId") Long certificationId,
//                            @Param("resumeId") Long resumeId);
//
//    @Transactional
//    @Modifying
//    void deleteCertificationEntityByResumeEntityIdAndId(Long resumeId, Long certificationId);
}

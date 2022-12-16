package com.maksgir.webbackend.repository;

import com.maksgir.webbackend.entity.AuditedMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditedMethodRepository extends JpaRepository<AuditedMethod, Long> {
}

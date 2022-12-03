package com.maksgir.webbackend.repository;

import com.maksgir.webbackend.entity.PointEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRepository extends JpaRepository<PointEntity, Long> {
}

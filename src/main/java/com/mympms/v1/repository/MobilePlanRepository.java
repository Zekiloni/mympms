package com.mympms.v1.repository;

import com.mympms.v1.entity.MobilePlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MobilePlanRepository extends JpaRepository<MobilePlan, Integer> {
}

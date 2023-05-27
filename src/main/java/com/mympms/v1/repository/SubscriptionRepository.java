package com.mympms.v1.repository;

import com.mympms.v1.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
}

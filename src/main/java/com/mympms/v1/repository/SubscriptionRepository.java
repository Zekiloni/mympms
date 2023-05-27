package com.mympms.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mympms.v1.entity.Subscription;


@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
}

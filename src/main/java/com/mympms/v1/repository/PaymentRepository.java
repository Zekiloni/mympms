package com.mympms.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mympms.v1.entity.Payment;


@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}

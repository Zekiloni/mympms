package com.mympms.v1.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mympms.v1.repository.PaymentRepository;
import com.mympms.v1.entity.Payment;


@Service
public class PaymentService {
    @Autowired
    private  PaymentRepository paymentRepository;

    public Payment create(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Optional<Payment> getOneById(int paymentId) {
        return paymentRepository.findById(paymentId);
    }
}

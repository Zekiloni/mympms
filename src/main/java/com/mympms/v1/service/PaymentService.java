package com.mympms.v1.service;


import com.mympms.v1.entity.Customer;
import com.mympms.v1.entity.MobilePlan;
import com.mympms.v1.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mympms.v1.repository.PaymentRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Service
public class PaymentService {
    @Autowired
    private  PaymentRepository paymentRepository;

    public Payment create(Customer customer, MobilePlan mobilePlan, BigDecimal amount) {
        Payment payment = new Payment();
        payment.setCustomer(customer);
        payment.setMobilePlan(mobilePlan);
        payment.setAmount(amount);
        payment.setPaymentDate(LocalDateTime.now());

        return paymentRepository.save(payment);
    }
}

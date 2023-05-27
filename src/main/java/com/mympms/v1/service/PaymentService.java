package com.mympms.v1.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mympms.v1.repository.PaymentRepository;
import com.mympms.v1.entity.Payment;


@Service
public class PaymentService implements BaseServiceInterface<Payment> {

    @Autowired
    private PaymentRepository paymentRepository;


    @Override
    public Payment create(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public void update(Payment payment) {
        paymentRepository.save(payment);
    }

    @Override
    public void delete(Payment payment) {
        paymentRepository.delete(payment);
    }

    @Override
    public void deleteMany(List<Payment> payments) {
        paymentRepository.deleteAll(payments);
    }

    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }


    @Override
    public Optional<Payment> getOneById(int paymentId) {
        return paymentRepository.findById(paymentId);
    }
}

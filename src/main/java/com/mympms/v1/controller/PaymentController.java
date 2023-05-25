package com.mympms.v1.controller;

import com.mympms.v1.entity.Payment;
import com.mympms.v1.service.PaymentService;
import com.mympms.v1.util.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment/{paymentId}")
    public ResponseEntity<Optional<Payment>> getOneById(@PathVariable int paymentId) {
        try {
            Optional<Payment> payment = paymentService.getOneById(paymentId);
            if (payment.isPresent()) {
                return ResponseEntity.ok(payment);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Throwable error) {
            LoggerUtil.error(error.getLocalizedMessage(), error);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/payment")
    public ResponseEntity<Payment> create(@RequestBody Payment payment) {
        try {
            Payment createdPayment = paymentService.create(payment);
            return ResponseEntity.ok(createdPayment);
        } catch (Throwable error) {
            LoggerUtil.error(error.getLocalizedMessage(), error);
            return ResponseEntity.internalServerError().build();
        }
    }
}

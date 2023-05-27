package com.mympms.v1.controller;

import com.mympms.v1.entity.Customer;
import com.mympms.v1.entity.Payment;
import com.mympms.v1.service.PaymentService;
import com.mympms.v1.util.LoggerUtilComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private LoggerUtilComponent loggerUtil;

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
            loggerUtil.error(error.getLocalizedMessage(), error);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/payment")
    public ResponseEntity<Payment> create(@AuthenticationPrincipal Authentication authentication, @RequestBody Payment payment) {
        try {
            if (authentication != null && authentication.getPrincipal() instanceof Customer customer) {
                payment.setCustomer(customer);

                Payment createdPayment = paymentService.create(payment);
                return ResponseEntity.ok(createdPayment);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        } catch (Throwable error) {
            loggerUtil.error(error.getLocalizedMessage(), error);
            return ResponseEntity.internalServerError().build();
        }
    }
}

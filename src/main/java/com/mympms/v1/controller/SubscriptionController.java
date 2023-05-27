package com.mympms.v1.controller;

import com.mympms.v1.entity.Customer;
import com.mympms.v1.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.mympms.v1.entity.Subscription;
import com.mympms.v1.service.SubscriptionService;
import com.mympms.v1.util.LoggerUtilComponent;


@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    @Autowired
    private LoggerUtilComponent loggerUtil;

    @Autowired
    private SubscriptionService subscriptionService;


    @GetMapping("/get-all")
    public ResponseEntity<List<Subscription>> getAll() {
        try {
            List<Subscription> subscriptions = subscriptionService.getAll();
            return ResponseEntity.ok(subscriptions);
        } catch (Exception exception) {
            loggerUtil.error(exception.getLocalizedMessage(), exception);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/subscription/{subscriptionId}")
    public ResponseEntity<Optional<Subscription>> getOneById(@PathVariable int subscriptionId) {
        try {
            Optional<Subscription> subscription = subscriptionService.getOneById(subscriptionId);
            if (subscription.isPresent()) {
                return ResponseEntity.ok(subscription);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception exception) {
            loggerUtil.error(exception.getLocalizedMessage(), exception);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/subscription")
    public ResponseEntity<Optional<Subscription>> create(@AuthenticationPrincipal Authentication authentication, @RequestBody Subscription subscription) {
        try {
            if (authentication != null && authentication.getPrincipal() instanceof Customer customer) {
                subscription.setCustomer(customer);

                Subscription createdSubscription = subscriptionService.create(subscription);
                return ResponseEntity.ok(Optional.ofNullable(createdSubscription));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        } catch (Throwable error) {
            loggerUtil.error(error.getLocalizedMessage(), error);
            return ResponseEntity.internalServerError().build();
        }
    }
}

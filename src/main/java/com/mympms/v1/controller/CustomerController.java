package com.mympms.v1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mympms.v1.service.CustomerService;
import com.mympms.v1.util.LoggerUtil;
import com.mympms.v1.entity.Customer;


@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    public CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAll() {
        try {
            List<Customer> customers = customerService.getAll();
            return ResponseEntity.ok(customers);
        } catch (Throwable error) {
            LoggerUtil.error(error.getLocalizedMessage(), error);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<Optional<Customer>> getOneById(@PathVariable int customerId) {
        try {
            Optional<Customer> customer = customerService.getOneById(customerId);
            if (customer.isPresent()) {
                return ResponseEntity.ok(customer);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Throwable error) {
            LoggerUtil.error(error.getLocalizedMessage(), error);
            return ResponseEntity.badRequest().build();
        }
    }
}
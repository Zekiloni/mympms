package com.mympms.v1.controller;

import com.mympms.v1.entity.Customer;
import com.mympms.v1.service.CustomerService;
import com.mympms.v1.util.LoggerUtilComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private LoggerUtilComponent loggerUtil;

    @Autowired
    public CustomerService customerService;


    @GetMapping
    public ResponseEntity<List<Customer>> getAll() {
        try {
            List<Customer> customers = customerService.getAll();
            return ResponseEntity.ok(customers);
        } catch (Throwable error) {
            loggerUtil.error(error.getLocalizedMessage(), error);
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
            loggerUtil.error(error.getLocalizedMessage(), error);
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        try {
            Customer createdCustomer = customerService.create(customer);
            return ResponseEntity.ok(createdCustomer);
        } catch (DataAccessException dataAccessException) {
            loggerUtil.error("Failed to create customer: {}" + dataAccessException.getLocalizedMessage(), dataAccessException);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

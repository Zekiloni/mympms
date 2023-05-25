package com.mympms.v1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mympms.v1.repository.CustomerRepository;
import com.mympms.v1.entity.Customer;


@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getOneById(int id) {
        return  customerRepository.findById(id);
    }
}

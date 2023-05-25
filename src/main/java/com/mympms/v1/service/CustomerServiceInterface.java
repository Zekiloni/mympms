package com.mympms.v1.service;

import java.util.List;
import java.util.Optional;

import com.mympms.v1.entity.Customer;


public interface CustomerServiceInterface {
    void create(Customer customer);
    void update(Customer customer);
    void delete(Customer customer);
    void deleteMany(List<Customer> customers);
    List<Customer> getAll();
    Optional<Customer> getOneById(int id);
}

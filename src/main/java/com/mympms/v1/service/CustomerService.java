package com.mympms.v1.service;

import com.mympms.v1.entity.Customer;
import com.mympms.v1.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerService implements BaseServiceInterface<Customer> {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public void deleteMany(List<Customer> customers) {
        customerRepository.deleteAll(customers);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getOneById(int id) {
        return  customerRepository.findById(id);
    }
}

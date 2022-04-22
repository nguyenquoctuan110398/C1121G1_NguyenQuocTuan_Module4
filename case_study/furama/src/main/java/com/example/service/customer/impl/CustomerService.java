package com.example.service.customer.impl;

import com.example.model.customer.Customer;
import com.example.repository.customer.ICustomerRepository;
import com.example.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findAll(String keyWord, Pageable pageable) {
        return iCustomerRepository.findAll(keyWord, pageable);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(Integer customerId) {
        return iCustomerRepository.findById(customerId).orElse(null);
    }

    @Override
    public void remove(Integer deleteByCustomerId) {
        iCustomerRepository.deleteById(deleteByCustomerId);
    }
}

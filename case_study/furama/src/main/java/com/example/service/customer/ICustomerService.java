package com.example.service.customer;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findAll(String keyWord, Pageable pageable);

    void save(Customer customer);

    Customer findById(Integer customerId);

    void remove(Integer deleteByCustomerId);

    List<Customer> findAllList();
}

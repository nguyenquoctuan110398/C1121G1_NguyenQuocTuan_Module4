package com.example.service.customer;

import com.example.model.customer.Customer;
import com.example.model.customer.CustomerUsingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerUsingServiceService {
//    Page<CustomerUsingService> findAll(Pageable pageable);
    List<CustomerUsingService> findAll();
}

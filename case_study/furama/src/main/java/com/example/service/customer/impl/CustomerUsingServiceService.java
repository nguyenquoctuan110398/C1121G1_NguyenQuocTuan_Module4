package com.example.service.customer.impl;

import com.example.model.customer.Customer;
import com.example.model.customer.CustomerUsingService;
import com.example.repository.customer.ICustomerUsingServiceRepository;
import com.example.service.customer.ICustomerUsingServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerUsingServiceService implements ICustomerUsingServiceService {

    @Autowired
    private ICustomerUsingServiceRepository iCustomerUsingServiceRepository;

    @Override
    public List<CustomerUsingService> findAll() {
        return iCustomerUsingServiceRepository.findAll();
    }

//    @Override
//    public Page<CustomerUsingService> findAll(Pageable pageable) {
//        return iCustomerUsingServiceRepository.findAll(pageable);
//    }
}

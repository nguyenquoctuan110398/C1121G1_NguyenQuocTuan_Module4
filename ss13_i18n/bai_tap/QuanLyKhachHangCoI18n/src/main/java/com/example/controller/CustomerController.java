package com.example.controller;

import com.example.model.Customer;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/customer")
@Controller
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("/list")
    public String showListCustomer(Model model, @PageableDefault(value = 2) Pageable pageable) {
        Page<Customer> customers = iCustomerService.findAll(pageable);

        model.addAttribute("customers", customers);
        return "/list";
    }

}

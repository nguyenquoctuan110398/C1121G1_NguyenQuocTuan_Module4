package com.example.controller.customer;

import com.example.dto.customer.CustomerDto;
import com.example.model.customer.Customer;
import com.example.model.customer.CustomerUsingService;
import com.example.service.customer.ICustomerService;
import com.example.service.customer.ICustomerTypeService;
import com.example.service.customer.ICustomerUsingServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @Autowired
    private ICustomerUsingServiceService iCustomerUsingServiceService;

    @GetMapping("/list")
    public String showListCustomer(Model model, @PageableDefault(value = 3) Pageable pageable,
                                   @RequestParam ("searchByName") Optional<String> nameSearch) {
        String keyWord = nameSearch.orElse("");

        Page<Customer> customers = iCustomerService.findAll(keyWord, pageable);
        model.addAttribute("customers", customers);
        model.addAttribute("keyWord", keyWord);
        return "/customer/list";
    }

    @GetMapping("/create")
    public String createCustomer(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerTypes", iCustomerTypeService.findAll());
        return "/customer/create";
    }

    @PostMapping("/save")
    public String saveCustomer(Model model, RedirectAttributes redirectAttributes,
                               @Valid @ModelAttribute CustomerDto customerDto,
                               BindingResult bindingResult,
                               Customer customer) {

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerTypes", iCustomerTypeService.findAll());
            return "/customer/create";
        } else {
            customerDto.setDeleteFlag(true);
            BeanUtils.copyProperties(customerDto, customer);
            redirectAttributes.addFlashAttribute("message", "Create customer success");

            iCustomerService.save(customer);
            return "redirect:/customers/list";
        }
    }

    @GetMapping("/edit/{customerId}")
    public String editCustomer(@PathVariable Integer customerId,
                               Model model) {
        Customer customer = iCustomerService.findById(customerId);
        if(customer != null) {
            CustomerDto customerDto = new CustomerDto();

            BeanUtils.copyProperties(customer, customerDto);
            model.addAttribute("customerDto", customerDto);
            model.addAttribute("customerTypes", iCustomerTypeService.findAll());
        }
        return "/customer/edit";
    }

    @PostMapping("/update")
    public String updateCustomer(Model model, RedirectAttributes redirectAttributes,
                                 @Valid @ModelAttribute CustomerDto customerDto,
                                 BindingResult bindingResult,
                                 Customer customer) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerTypes", iCustomerTypeService.findAll());
            return "/customer/edit";
        } else {

            BeanUtils.copyProperties(customerDto, customer);
            redirectAttributes.addFlashAttribute("message", "Update customer success");

            iCustomerService.save(customer);
            return "redirect:/customers/list";
        }
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam Integer deleteByCustomerId) {
//        iCustomerService.remove(deleteByCustomerId);
        Customer customer = iCustomerService.findById(deleteByCustomerId);
        customer.setDeleteFlag(false);
        iCustomerService.save(customer);
        return "redirect:/customers/list";
    }

    @GetMapping("/customer-list-using-service")
    public String showListCustomerUsingService(Model model){
//        Page<CustomerUsingService> customerUsingServices = iCustomerUsingServiceService.findAll(pageable);
        List<CustomerUsingService> customerUsingServices = iCustomerUsingServiceService.findAll();
        model.addAttribute("customerUsingServices", customerUsingServices);
        return "/customer/list_customer_using_service";
    }
}

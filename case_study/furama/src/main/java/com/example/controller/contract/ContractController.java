package com.example.controller.contract;

import com.example.dto.contract.ContractDto;
import com.example.model.contract.Contract;
import com.example.service.contract.IContractService;
import com.example.service.customer.ICustomerService;
import com.example.service.employee.IEmployeeService;
import com.example.service.service.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/contracts")
public class ContractController {

    @Autowired
    private IContractService iContractService;

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IFacilityService iFacilityService;

    @GetMapping("/list")
    public String showListContract(Model model, @PageableDefault(value = 3) Pageable pageable){
        Page<Contract> contracts = iContractService.findAll(pageable);
        model.addAttribute("contracts", contracts);
        return "/contract/list";
    }

    @GetMapping("/create")
    public String createContractForm(Model model){
        model.addAttribute("employees", iEmployeeService.findAllList());
        model.addAttribute("customers", iCustomerService.findAllList());
        model.addAttribute("services", iFacilityService.findAllList());
        model.addAttribute("contractDto", new ContractDto());
        return "/contract/create";
    }

    @PostMapping("/save")
    public String saveContract(Model model, RedirectAttributes redirectAttributes,
                               @Valid @ModelAttribute ContractDto contractDto,
                               BindingResult bindingResult,
                               Contract contract){

        contractDto.validate(contractDto, bindingResult);

        if (bindingResult.hasFieldErrors()){
            model.addAttribute("employees", iEmployeeService.findAllList());
            model.addAttribute("customers", iCustomerService.findAllList());
            model.addAttribute("services", iFacilityService.findAllList());
            return "/contract/create";
        } else {
            BeanUtils.copyProperties(contractDto, contract);
            contract.setEmployee(contractDto.getEmployee());
            contract.setCustomer(contractDto.getCustomer());
            contract.setServices(contractDto.getServices());

            redirectAttributes.addFlashAttribute("message", "Create contract success!");
            iContractService.save(contract);
            return "redirect:/contracts/list";
        }
    }
}

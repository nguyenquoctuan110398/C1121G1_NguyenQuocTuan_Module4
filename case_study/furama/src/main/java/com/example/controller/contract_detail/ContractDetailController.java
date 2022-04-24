package com.example.controller.contract_detail;

import com.example.model.contract.ContractDetail;
import com.example.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contract-details")
public class ContractDetailController {

    @Autowired
    private IContractDetailService iContractDetailService;

    @GetMapping("/list")
    public String showListContractDetail(Model model, @PageableDefault(value = 3) Pageable pageable){
        Page<ContractDetail> contractDetails = iContractDetailService.findAll(pageable);
        model.addAttribute("contractDetails", contractDetails);

        return "/contract_detail/list";
    }

    @GetMapping("/view/{contractDetailId}")
    public String view(@PathVariable Integer contractDetailId, Model model){
        model.addAttribute("contractDetail", iContractDetailService.findById(contractDetailId));
        return "/contract_detail/view";
    }
}

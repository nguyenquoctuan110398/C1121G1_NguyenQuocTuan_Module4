package com.example.service.contract.impl;

import com.example.model.contract.ContractDetail;
import com.example.repository.customer.IContractDetailRepository;
import com.example.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailService implements IContractDetailService {

    @Autowired
    private IContractDetailRepository iContractDetailRepository;

    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return iContractDetailRepository.findAll(pageable);
    }

    @Override
    public ContractDetail findById(Integer contractDetailId) {
        return iContractDetailRepository.findById(contractDetailId).orElse(null);
    }
}

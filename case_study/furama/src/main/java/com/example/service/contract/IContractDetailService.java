package com.example.service.contract;

import com.example.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractDetailService {
    Page<ContractDetail> findAll(Pageable pageable);

    ContractDetail findById(Integer contractDetailId);
}

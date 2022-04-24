package com.example.service.contract.impl;

import com.example.repository.customer.IAttachServiceRepository;
import com.example.service.contract.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttachServiceService implements IAttachServiceService {

    @Autowired
    private IAttachServiceRepository iAttachServiceRepository;
}

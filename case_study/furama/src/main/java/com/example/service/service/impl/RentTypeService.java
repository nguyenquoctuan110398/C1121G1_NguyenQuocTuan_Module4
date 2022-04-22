package com.example.service.service.impl;

import com.example.model.service.RentType;
import com.example.repository.service.IRentTypeRepository;
import com.example.service.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {

    @Autowired
    private IRentTypeRepository iRentTypeRepository;


    @Override
    public List<RentType> findAll() {
        return iRentTypeRepository.findAll();
    }
}

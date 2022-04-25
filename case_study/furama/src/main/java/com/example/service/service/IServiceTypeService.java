package com.example.service.service;

import com.example.model.service.ServiceType;

import java.util.List;

public interface IServiceTypeService {
    List<ServiceType> findAll();

    ServiceType findById(Integer id);
}

package com.example.service.service;

import com.example.model.service.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IFacilityService {
    Page<Services> findAll(Pageable pageable);

    void save(Services services);
}

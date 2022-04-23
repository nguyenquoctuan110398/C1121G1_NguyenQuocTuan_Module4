package com.example.service.service;

import com.example.model.service.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IFacilityService {
    Page<Services> findAll(Pageable pageable);

    void save(Services services);

    List<Services> findAllList();
}

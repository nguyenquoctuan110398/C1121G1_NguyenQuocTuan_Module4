package com.example.service.service.impl;

import com.example.model.service.Services;
import com.example.repository.service.IFacilityRepository;
import com.example.service.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private IFacilityRepository iFacilityRepository;

    @Override
    public Page<Services> findAll(Pageable pageable) {
        return iFacilityRepository.findAll(pageable);
    }

    @Override
    public void save(Services services) {
        iFacilityRepository.save(services);
    }

    @Override
    public List<Services> findAllList() {
        return iFacilityRepository.findAllList();
    }


}

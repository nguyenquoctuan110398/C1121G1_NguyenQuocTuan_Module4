package com.example.repository.service;

import com.example.model.service.Services;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityRepository extends JpaRepository<Services, Integer> {
}

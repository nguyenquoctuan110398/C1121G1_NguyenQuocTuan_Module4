package com.example.repository.service;

import com.example.model.service.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IFacilityRepository extends JpaRepository<Services, Integer> {

    @Query(value = "select * from services", nativeQuery = true)
    List<Services> findAllList();
}

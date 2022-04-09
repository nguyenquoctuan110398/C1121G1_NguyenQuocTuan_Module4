package com.example.service;

import com.example.dto.SoTietKiemDto;
import com.example.model.SoTietKiem;

import java.util.List;

public interface ISoTietKiemService {
    List<SoTietKiem> findAll();

    void save(SoTietKiem soTietKiem);

    SoTietKiem findById(Integer maSoTietKiem);

    void delete(Integer maSoTietKiem);
}

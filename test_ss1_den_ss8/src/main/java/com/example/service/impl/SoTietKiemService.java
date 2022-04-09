package com.example.service.impl;

import com.example.dto.SoTietKiemDto;
import com.example.model.SoTietKiem;
import com.example.repository.ISoTietKiemRepository;
import com.example.service.ISoTietKiemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoTietKiemService implements ISoTietKiemService {

    @Autowired
    private ISoTietKiemRepository iSoTietKiemRepository;

    @Override
    public List<SoTietKiem> findAll() {
        return iSoTietKiemRepository.findAll();
    }

    @Override
    public void save(SoTietKiem soTietKiem) {
        iSoTietKiemRepository.save(soTietKiem);
    }

    @Override
    public SoTietKiem findById(Integer maSoTietKiem) {
        return iSoTietKiemRepository.findById(maSoTietKiem).orElse(null);
    }

    @Override
    public void delete(Integer maSoTietKiem) {
        iSoTietKiemRepository.deleteById(maSoTietKiem);
    }
}

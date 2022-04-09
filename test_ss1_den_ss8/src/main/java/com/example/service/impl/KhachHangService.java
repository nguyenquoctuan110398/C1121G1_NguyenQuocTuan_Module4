package com.example.service.impl;

import com.example.dto.KhachHangDto;
import com.example.model.KhachHang;
import com.example.repository.IKhachHangRepository;
import com.example.service.IKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class KhachHangService implements IKhachHangService {

    @Autowired
    private IKhachHangRepository iKhachHangRepository;

    @Override
    public List<KhachHang> findAll() {
        return iKhachHangRepository.findAll();
    }

    @Override
    public void save(KhachHang khachHang) {
        iKhachHangRepository.save(khachHang);
    }

    @Override
    public KhachHang findByTenKhachHangAndMaKhachHangEquals(String tenKhachHang, String maKhachHang) {
        return iKhachHangRepository.findByTenKhachHangAndMaKhachHangEquals(tenKhachHang, maKhachHang);
    }
}

package com.example.service;

import com.example.dto.KhachHangDto;
import com.example.model.KhachHang;

import java.util.List;
import java.util.Set;

public interface IKhachHangService {
    List<KhachHang> findAll();

    void save(KhachHang khachHang);

    KhachHang findByTenKhachHangAndMaKhachHangEquals(String tenKhachHang, String maKhachHang);
}

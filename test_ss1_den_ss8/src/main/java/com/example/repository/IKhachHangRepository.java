package com.example.repository;

import com.example.dto.KhachHangDto;
import com.example.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IKhachHangRepository extends JpaRepository<KhachHang, Integer> {
    KhachHang findByTenKhachHangAndMaKhachHangEquals(String tenKhachHang, String maKhachHang);
}

package com.example.repository;

import com.example.dto.KhachHangDto;
import com.example.model.KhachHang;
import com.example.model.SoTietKiem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IKhachHangRepository extends JpaRepository<KhachHang, Integer> {
    KhachHang findByTenKhachHangAndMaKhachHangEquals(String tenKhachHang, String maKhachHang);

}

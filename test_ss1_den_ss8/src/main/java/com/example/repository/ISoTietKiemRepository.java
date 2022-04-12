package com.example.repository;

import com.example.model.SoTietKiem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISoTietKiemRepository extends JpaRepository<SoTietKiem, Integer> {
    List<SoTietKiem> findAllByKhachHang_TenKhachHangContaining(String tenKhachHang);
}

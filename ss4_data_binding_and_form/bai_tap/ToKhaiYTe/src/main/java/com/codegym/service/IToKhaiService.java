package com.codegym.service;

import com.codegym.model.ToKhaiYTe;

import java.util.List;

public interface IToKhaiService {
    List<String> getAllQuocTich();
    List<String> getAllGioiTinh();
    List<String> getAllTinhThanh();
    List<String> getAllQuanHuyen();
    List<String> getAllPhuongXa();
    List<Integer> getAllCoKhong();
    List<String> getAllPhuongTien();
    void save(ToKhaiYTe toKhaiYTe);
}

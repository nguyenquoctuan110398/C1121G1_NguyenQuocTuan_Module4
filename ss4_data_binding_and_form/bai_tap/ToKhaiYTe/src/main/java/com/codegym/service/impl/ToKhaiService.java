package com.codegym.service.impl;

import com.codegym.model.ToKhaiYTe;
import com.codegym.service.IToKhaiService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToKhaiService implements IToKhaiService {

    private static List<String> quocTich = new ArrayList<>();
    private static List<String> gioiTinh = new ArrayList<>();
    private static List<String> tinhThanh = new ArrayList<>();
    private static List<String> quanHuyen = new ArrayList<>();
    private static List<String> phuongXa = new ArrayList<>();
    private static List<Integer> coKhong = new ArrayList<>();
    private static List<ToKhaiYTe> listToKhaiYTe = new ArrayList<>();
    private static List<String> phuongTien = new ArrayList<>();

    static {
        quocTich.add("Viet Nam");
        quocTich.add("My");
        quocTich.add("Khac");

        gioiTinh.add("Nam");
        gioiTinh.add("Nu");

        tinhThanh.add("Da Nang");

        quanHuyen.add("Thanh Khe");
        quanHuyen.add("Lien Chieu");
        quanHuyen.add("Cam Le");
        quanHuyen.add("Hai Chau");

        phuongXa.add("Vinh Trung");
        phuongXa.add("Hoa Khanh");
        phuongXa.add("Hoa Vang");
        phuongXa.add("Tan Chinh");

        coKhong.add(0);
        coKhong.add(1);

        phuongTien.add("O To");
        phuongTien.add("Xe May");
        phuongTien.add("Xe Khach");
        phuongTien.add("Khac");
    }

    @Override
    public List<String> getAllQuocTich() {
        return quocTich;
    }

    @Override
    public List<String> getAllGioiTinh() {
        return gioiTinh;
    }

    @Override
    public List<String> getAllTinhThanh() {
        return tinhThanh;
    }

    @Override
    public List<String> getAllQuanHuyen() {
        return quanHuyen;
    }

    @Override
    public List<String> getAllPhuongXa() {
        return phuongXa;
    }

    @Override
    public List<Integer> getAllCoKhong() {
        return coKhong;
    }

    @Override
    public List<String> getAllPhuongTien() {
        return phuongTien;
    }

    @Override
    public void save(ToKhaiYTe toKhaiYTe) {
        listToKhaiYTe.add(toKhaiYTe);
    }
}

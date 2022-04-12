package com.example.service.impl;

import com.example.dto.SoTietKiemDto;
import com.example.model.SoTietKiem;
import com.example.repository.ISoTietKiemRepository;
import com.example.service.ISoTietKiemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

    @Override
    public List<SoTietKiem> searchByAll(String ngayBatDau, String ngayKetThuc, String tenKhachHangCanTim) {
        List<SoTietKiem> soTietKiems = iSoTietKiemRepository.findAll();
        List<SoTietKiem> soTietKiemResults = new ArrayList<>();

        for (SoTietKiem soTietKiem : soTietKiems) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date1 = LocalDate.parse(ngayBatDau, dateTimeFormatter);
            LocalDate date2 = LocalDate.parse(ngayKetThuc, dateTimeFormatter);

            String thoiGianGui = soTietKiem.getThoiGianGui();

            LocalDate date3 = LocalDate.parse(thoiGianGui, dateTimeFormatter);

            if (date1.isBefore(date3) && date2.isAfter(date3)) {
                if (soTietKiem.getKhachHang().getTenKhachHang().contains(tenKhachHangCanTim)) {
                    soTietKiemResults.add(soTietKiem);
                }
            }
        }
        return soTietKiemResults;
    }

    @Override
    public List<SoTietKiem> searchByDayStartAndDayEnd(String ngayBatDau, String ngayKetThuc) {
        List<SoTietKiem> soTietKiems = iSoTietKiemRepository.findAll();
        List<SoTietKiem> soTietKiemResults = new ArrayList<>();

        for (SoTietKiem soTietKiem : soTietKiems) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date1 = LocalDate.parse(ngayBatDau, dateTimeFormatter);
            LocalDate date2 = LocalDate.parse(ngayKetThuc, dateTimeFormatter);

            String thoiGianGui = soTietKiem.getThoiGianGui();

            LocalDate date3 = LocalDate.parse(thoiGianGui, dateTimeFormatter);

            if (date1.isBefore(date3) && date2.isAfter(date3)) {
                soTietKiemResults.add(soTietKiem);
            }
        }
        return soTietKiemResults;
    }

    @Override
    public List<SoTietKiem> searchByName(String tenKhachHangCanTim) {
        return iSoTietKiemRepository.findAllByKhachHang_TenKhachHangContaining(tenKhachHangCanTim);
    }
}

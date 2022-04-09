package com.example.dto;

import org.hibernate.validator.constraints.Range;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SoTietKiemDto implements Validator {

    private Integer maSoTietKiem;

    @NotBlank
    private String thoiGianGui;

    @NotNull
    @Range(min = 1)
    private Integer kyHan;

    @NotNull
    @Min(value = 30000000, message = "Nhập số tiền > 30000000")
    private Double soTienGui;

    @Valid
    private KhachHangDto khachHangDto;

    public SoTietKiemDto() {
    }

    public Integer getMaSoTietKiem() {
        return maSoTietKiem;
    }

    public void setMaSoTietKiem(Integer maSoTietKiem) {
        this.maSoTietKiem = maSoTietKiem;
    }

    public String getThoiGianGui() {
        return thoiGianGui;
    }

    public void setThoiGianGui(String thoiGianGui) {
        this.thoiGianGui = thoiGianGui;
    }

    public Integer getKyHan() {
        return kyHan;
    }

    public void setKyHan(Integer kyHan) {
        this.kyHan = kyHan;
    }

    public Double getSoTienGui() {
        return soTienGui;
    }

    public void setSoTienGui(Double soTienGui) {
        this.soTienGui = soTienGui;
    }

    public KhachHangDto getKhachHangDto() {
        return khachHangDto;
    }

    public void setKhachHangDto(KhachHangDto khachHang) {
        this.khachHangDto = khachHang;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SoTietKiemDto soTietKiemDto = (SoTietKiemDto) target;
        String thoiGianGui = soTietKiemDto.getThoiGianGui();

        if (thoiGianGui.matches("^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$")) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate now = LocalDate.now();
            LocalDate date = LocalDate.parse(thoiGianGui, dateTimeFormatter);
            if (date.isBefore(now)) {
                errors.rejectValue("thoiGianGui",
                        "createDate.before",
                        "Ngày nhập không hợp lệ! Không được chọn ngày quá khứ");
            }
        }

    }
}


package com.example.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class KhachHangDto {
    private Integer id;

    @NotBlank
    @Pattern(regexp = "(^$|^[\\p{Lu}\\p{Ll}]+( [\\p{Lu}\\p{Ll}]+)*$)", message = "Sai định dạng tên")
    private String tenKhachHang;

    @NotBlank
    @Pattern(regexp = "^(KH)-[0-9]{4}$", message = "Sai định dạng mã, mã khách hàng phải là KH-XXXX")
    private String maKhachHang;

    public KhachHangDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }
}

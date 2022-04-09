package com.example.model;

import javax.persistence.*;

@Entity
@Table
public class SoTietKiem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maSoTietKiem;

    @Column(columnDefinition = "date")
    private String thoiGianGui;
    private Integer kyHan;
    private Double soTienGui;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "khach_hang_id", referencedColumnName = "id")
    private KhachHang khachHang;

    public SoTietKiem() {
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

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }
}

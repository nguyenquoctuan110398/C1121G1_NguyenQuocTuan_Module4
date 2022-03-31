package com.codegym.controller;

import com.codegym.model.ToKhaiYTe;
import com.codegym.service.IToKhaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ToKhaiController {

    @Autowired
    IToKhaiService iToKhaiService;

    @GetMapping("toKhai")
    public String bangDienToKhaiYTe(Model model){
        List<String> quocTich = iToKhaiService.getAllQuocTich();
        List<String> gioiTinh = iToKhaiService.getAllGioiTinh();
        List<String> tinhThanh = iToKhaiService.getAllTinhThanh();
        List<String> quanHuyen = iToKhaiService.getAllQuanHuyen();
        List<String> phuongXa = iToKhaiService.getAllPhuongXa();
        List<String> phuongTien = iToKhaiService.getAllPhuongTien();
        List<Integer> coKhong = iToKhaiService.getAllCoKhong();

        model.addAttribute("quocTich", quocTich);
        model.addAttribute("gioiTinh", gioiTinh);
        model.addAttribute("tinhThanh", tinhThanh);
        model.addAttribute("quanHuyen", quanHuyen);
        model.addAttribute("phuongXa", phuongXa);
        model.addAttribute("coKhong", coKhong);
        model.addAttribute("toKhaiYTe", new ToKhaiYTe());
        model.addAttribute("phuongTien", phuongTien);
        return "to-khai-y-te";
    }

    @PostMapping("/toKhai")
    public String khaiBaoYTe(@ModelAttribute ToKhaiYTe toKhaiYTe, Model model) {
        iToKhaiService.save(toKhaiYTe);
        model.addAttribute("toKhaiYTe", toKhaiYTe);
        model.addAttribute("message", "Khai báo thành công!");

        return "hien-thi-thong-tin";
    }
}

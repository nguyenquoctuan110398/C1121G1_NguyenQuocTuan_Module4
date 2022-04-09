package com.example.controller;

import com.example.dto.KhachHangDto;
import com.example.model.KhachHang;
import com.example.service.IKhachHangService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/khach-hang")
@Controller
public class KhachHangController {

    @Autowired
    private IKhachHangService iKhachHangService;

    @GetMapping("")
    public String danhSachKhachHang(Model model){
        List<KhachHang> khachHangs = iKhachHangService.findAll();
        model.addAttribute("khachHangs", khachHangs);

        return "/KhachHang/list";
    }

    @GetMapping("/them")
    public String themMoiKhachHang(Model model){
        model.addAttribute("khachHangDto", new KhachHangDto());

        return "/KhachHang/create";
    }

    @PostMapping("/luu")
    public String luuKhachHang(@Valid @ModelAttribute KhachHangDto khachHangDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               KhachHang khachHang){

        if (bindingResult.hasFieldErrors()){
            return "/KhachHang/create";
        }

        BeanUtils.copyProperties(khachHangDto, khachHang);

        redirectAttributes.addFlashAttribute("message", "Thêm mới khách hàng thành công");
        iKhachHangService.save(khachHang);

        return "redirect:/khach-hang";

    }
}

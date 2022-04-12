package com.example.controller;

import com.example.dto.KhachHangDto;
import com.example.dto.SoTietKiemDto;
import com.example.model.KhachHang;
import com.example.model.SoTietKiem;
import com.example.service.IKhachHangService;
import com.example.service.ISoTietKiemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("/so-tiet-kiem")
@Controller
public class SoTietKiemController {

    @Autowired
    private ISoTietKiemService iSoTietKiemService;

    @Autowired
    private IKhachHangService iKhachHangService;

    @ModelAttribute("khachHangs")
    public List<KhachHang> khachHangs() {
        return iKhachHangService.findAll();
    }

    @GetMapping("")
    public String danhSachSoTietKiem(Model model) {
        List<SoTietKiem> soTietKiems = iSoTietKiemService.findAll();
        model.addAttribute("soTietKiems", soTietKiems);
        return "/SoTietKiem/list";
    }

    @GetMapping("/them")
    public String themSoTietKiem(Model model) {
        model.addAttribute("soTietKiemDto", new SoTietKiemDto());
        return "/SoTietKiem/create";
    }

    @PostMapping("/luu")
    public String themSoTietKiem(@Valid @ModelAttribute SoTietKiemDto soTietKiemDto,
                                 BindingResult bindingResult, RedirectAttributes redirectAttributes,
                                 SoTietKiem soTietKiem) {
        soTietKiemDto.validate(soTietKiemDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/SoTietKiem/create";
        }

        BeanUtils.copyProperties(soTietKiemDto, soTietKiem);

        KhachHang khachHangKiemTra =
                iKhachHangService.findByTenKhachHangAndMaKhachHangEquals
                        (soTietKiemDto.getKhachHangDto().getTenKhachHang(),
                                soTietKiemDto.getKhachHangDto().getMaKhachHang());
        KhachHang khachHang = new KhachHang();

        if (!(khachHangKiemTra == null)) {
            soTietKiem.setKhachHang(khachHangKiemTra);
        } else {
            khachHang.setId(soTietKiemDto.getKhachHangDto().getId());
            khachHang.setMaKhachHang(soTietKiemDto.getKhachHangDto().getMaKhachHang());
            khachHang.setTenKhachHang(soTietKiemDto.getKhachHangDto().getTenKhachHang());
            soTietKiem.setKhachHang(khachHang);
        }

        redirectAttributes.addFlashAttribute("message", "Thêm mới sổ tiết kiệm thành công");
        iSoTietKiemService.save(soTietKiem);

        return "redirect:/so-tiet-kiem";
    }

    @GetMapping("/sua/{maSoTietKiem}")
    public String suaThongTinSoTietKiem(@PathVariable Integer maSoTietKiem,
                                        Model model) {
        SoTietKiem soTietKiem = iSoTietKiemService.findById(maSoTietKiem);
        SoTietKiemDto soTietKiemDto = new SoTietKiemDto();

        BeanUtils.copyProperties(soTietKiem, soTietKiemDto);

        KhachHangDto khachHangDto = new KhachHangDto();
        khachHangDto.setId(soTietKiem.getKhachHang().getId());
        khachHangDto.setMaKhachHang(soTietKiem.getKhachHang().getMaKhachHang());
        khachHangDto.setTenKhachHang(soTietKiem.getKhachHang().getTenKhachHang());

        soTietKiemDto.setKhachHangDto(khachHangDto);

        model.addAttribute("soTietKiemDto", soTietKiemDto);

        return "/SoTietKiem/edit";
    }

    @PostMapping("/sua")
    public String luuThongTinSoTietKiem(@Valid @ModelAttribute SoTietKiemDto soTietKiemDto,
                                        BindingResult bindingResult,
                                        RedirectAttributes redirectAttributes,
                                        SoTietKiem soTietKiem) {

        soTietKiemDto.validate(soTietKiemDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/SoTietKiem/edit";
        }

        BeanUtils.copyProperties(soTietKiemDto, soTietKiem);

        KhachHang khachHang = new KhachHang();
        khachHang.setId(soTietKiemDto.getKhachHangDto().getId());
        khachHang.setMaKhachHang(soTietKiemDto.getKhachHangDto().getMaKhachHang());
        khachHang.setTenKhachHang(soTietKiemDto.getKhachHangDto().getTenKhachHang());

        soTietKiem.setKhachHang(khachHang);

        redirectAttributes.addFlashAttribute("message", "Sửa thông tin sổ thành công");
        iSoTietKiemService.save(soTietKiem);

        return "redirect:/so-tiet-kiem";
    }

    @GetMapping("/xoa/{maSoTietKiem}")
    public String delete(@PathVariable Integer maSoTietKiem, Model model) {
        model.addAttribute("soTietKiem", iSoTietKiemService.findById(maSoTietKiem));
        return "/SoTietKiem/delete";
    }

    @PostMapping("/xoa")
    public String delete(SoTietKiem soTietKiem) {
        iSoTietKiemService.delete(soTietKiem.getMaSoTietKiem());
        return "redirect:/so-tiet-kiem";
    }

    @GetMapping("/tim-kiem")
    public String search(@RequestParam Optional<String> ngayBatDau,
                         @RequestParam Optional<String> ngayKetThuc,
                         @RequestParam Optional<String> tenKhachHangCanTim,
                         Model model) {
        List<SoTietKiem> soTietKiems = null;

        if ((!ngayBatDau.isPresent() || ngayBatDau.get().equals(""))
                && (!ngayKetThuc.isPresent() || ngayKetThuc.get().equals(""))){
            if (tenKhachHangCanTim.isPresent() && !(tenKhachHangCanTim.get().equals(""))){
                soTietKiems = iSoTietKiemService.searchByName(tenKhachHangCanTim.get());
                model.addAttribute("tenKhachHangCanTim", tenKhachHangCanTim);
                model.addAttribute("soTietKiems", soTietKiems);
                return "/SoTietKiem/list";
            } else {
                return "redirect:/so-tiet-kiem";
            }
        }

        if (ngayBatDau.isPresent() && !(ngayBatDau.get().equals(""))
                && ngayKetThuc.isPresent() && !(ngayKetThuc.get().equals(""))){
            if (tenKhachHangCanTim.isPresent()){
                soTietKiems = iSoTietKiemService.searchByAll(ngayBatDau.get(),
                        ngayKetThuc.get(), tenKhachHangCanTim.get());

                model.addAttribute("ngayBatDau", ngayBatDau);
                model.addAttribute("ngayKetThuc", ngayKetThuc);
                model.addAttribute("tenKhachHangCanTim", tenKhachHangCanTim);

                return "/SoTietKiem/list";
            } else {
                soTietKiems = iSoTietKiemService.searchByDayStartAndDayEnd(ngayBatDau.get(), ngayKetThuc.get());

                model.addAttribute("ngayBatDau", ngayBatDau);
                model.addAttribute("ngayKetThuc", ngayKetThuc);

                return "/SoTietKiem/list";
            }
        }
        return "redirect:/so-tiet-kiem";
    }

}

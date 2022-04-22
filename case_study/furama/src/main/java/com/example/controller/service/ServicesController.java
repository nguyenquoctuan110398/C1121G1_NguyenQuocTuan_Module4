package com.example.controller.service;

import com.example.dto.service.ServiceDto;
import com.example.model.service.Services;
import com.example.service.service.IFacilityService;
import com.example.service.service.IRentTypeService;
import com.example.service.service.IServiceTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/services")
public class ServicesController {

    @Autowired
    private IFacilityService iFacilityService;

    @Autowired
    private IServiceTypeService iServiceTypeService;

    @Autowired
    private IRentTypeService iRentTypeService;

    @GetMapping("/list")
    public String showListService(Model model, @PageableDefault(value = 3) Pageable pageable) {
        Page<Services> services = iFacilityService.findAll(pageable);
        model.addAttribute("services", services);

        model.addAttribute("serviceTypes", iServiceTypeService.findAll());
        model.addAttribute("rentTypes", iRentTypeService.findAll());

        return "/service/list";
    }

    @GetMapping("/create/{id}")
    public String createService(Model model, @PathVariable Integer id) {
        model.addAttribute("id", id);
        model.addAttribute("rentTypes", iRentTypeService.findAll());
        model.addAttribute("serviceTypes", iServiceTypeService.findAll());
        model.addAttribute("serviceDto", new ServiceDto());
        return "/service/create";
    }

    @PostMapping("/save")
    public String saveService(Model model, RedirectAttributes redirectAttributes,
                              @Valid @ModelAttribute ServiceDto serviceDto,
                              BindingResult bindingResult,
                              Services services) {
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("rentTypes", iRentTypeService.findAll());
            return "/service/create";
        } else {
            BeanUtils.copyProperties(serviceDto, services);
            redirectAttributes.addFlashAttribute("message", "Create service success");

            iFacilityService.save(services);
            return "redirect:/services/list";
        }
    }
}

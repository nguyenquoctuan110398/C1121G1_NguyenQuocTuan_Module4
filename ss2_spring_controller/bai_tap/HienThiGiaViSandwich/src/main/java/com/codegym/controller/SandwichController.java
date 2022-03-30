package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {

    @GetMapping("/sandwich")
    public String getChooseIndex() {
        return "home";
    }

    @RequestMapping("/save")
    public String save(@RequestParam(value = "condiment", required = false, defaultValue = "Not valiable")
                                   String[] condiment, Model model) {
        model.addAttribute("condiment", condiment);

        return "home";
    }
}

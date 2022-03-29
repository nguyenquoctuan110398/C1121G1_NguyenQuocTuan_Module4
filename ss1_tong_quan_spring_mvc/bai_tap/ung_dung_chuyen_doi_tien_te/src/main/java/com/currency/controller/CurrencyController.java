package com.currency.controller;

import com.currency.service.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {

    @GetMapping("/currency")
    public String goCurrency() {
        return "currency";
    }

    @Autowired
    ICurrencyService currencyService;

    @PostMapping("/currency")
    public String result(@RequestParam Double usd, Model model) {
        Double vnd = this.currencyService.resultUsdToVnd(usd);
        model.addAttribute("vnd", vnd);
        return "currency";
    }
}

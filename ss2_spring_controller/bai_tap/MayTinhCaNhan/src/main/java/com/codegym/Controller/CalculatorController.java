package com.codegym.Controller;

import com.codegym.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    private ICalculatorService iCalculatorService;

    @GetMapping("/Calculator")
    public String getCalculator() {
        return "calculator";
    }

    @PostMapping(value = "/Calculator")
    public String result(@RequestParam Double number1,
                         @RequestParam Double number2,
                         @RequestParam String operation,
                         Model model) {
        Double result = null;

        switch (operation) {
            case "Addition(+)":
                result = iCalculatorService.addition(number1, number2);
                break;
            case "Subtraction(-)":
                result = iCalculatorService.subtraction(number1, number2);
                break;
            case "Multiplication(*)":
                result = iCalculatorService.multiplication(number1, number2);
                break;
            case "Division(/)":
                result = iCalculatorService.division(number1, number2);
                break;
        }
        model.addAttribute("result", result);

        return "calculator";
    }

}

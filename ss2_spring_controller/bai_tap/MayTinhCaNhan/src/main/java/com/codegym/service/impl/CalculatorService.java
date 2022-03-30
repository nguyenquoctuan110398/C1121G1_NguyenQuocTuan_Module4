package com.codegym.service.impl;

import com.codegym.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public Double addition(Double number1, Double number2) {
        return number1 + number2;
    }

    @Override
    public Double subtraction(Double number1, Double number2) {
        return number1 - number2;
    }

    @Override
    public Double multiplication(Double number1, Double number2) {
        return number1 * number2;
    }

    @Override
    public Double division(Double number1, Double number2) {
        return number1 / number2;
    }
}

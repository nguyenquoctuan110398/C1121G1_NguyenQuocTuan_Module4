package com.currency.service.impl;

import com.currency.service.ICurrencyService;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService implements ICurrencyService {
    @Override
    public Double resultUsdToVnd(Double usd) {
        return usd * 23000;
    }
}

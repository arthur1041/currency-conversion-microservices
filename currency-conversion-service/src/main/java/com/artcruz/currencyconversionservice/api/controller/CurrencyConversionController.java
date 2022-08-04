package com.artcruz.currencyconversionservice.api.controller;

import com.artcruz.currencyconversionservice.api.response.CurrencyConversionResponse;
import com.artcruz.currencyconversionservice.api.response.CurrencyExchangeResponse;
import com.artcruz.currencyconversionservice.proxy.CurrencyExchangeProxy;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


@AllArgsConstructor
@RestController
public class CurrencyConversionController {

    private final CurrencyExchangeProxy proxy;

    private final Environment environment;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionResponse calculateCurrencyConversionFeign(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity) {

        CurrencyExchangeResponse currencyExchangeResponse = proxy.retrieveExchangeValue(from, to);

        return new CurrencyConversionResponse().builder()
                .from(from)
                .to(to)
                .quantity(quantity)
                .conversionMultiple(currencyExchangeResponse.getConversionMultiple())
                .totalCalculatedAmount(quantity.multiply(currencyExchangeResponse.getConversionMultiple()))
                .environment(currencyExchangeResponse.getEnvironment())
                .build();
    }

}

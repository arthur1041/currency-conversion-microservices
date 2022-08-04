package com.artcruz.currencyexchangeservice.api.controller;

import com.artcruz.currencyexchangeservice.api.response.CurrencyExchangeResponse;
import com.artcruz.currencyexchangeservice.model.entity.CurrencyExchange;
import com.artcruz.currencyexchangeservice.model.repository.CurrencyExchangeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class CurrencyExchangeController {

    private final CurrencyExchangeRepository repository;

    private final Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchangeResponse retrieveExchangeValue(
            @PathVariable(name = "from") String originCurrency,
            @PathVariable(name = "to") String destinyCurrency) {

        CurrencyExchange currencyExchange = repository.findByFromAndTo(originCurrency, destinyCurrency);

        if (currencyExchange == null)
            throw new RuntimeException("Unable to find data for " + originCurrency + " to " + destinyCurrency);

        return new CurrencyExchangeResponse().builder()
                .from(currencyExchange.getFrom())
                .to(currencyExchange.getTo())
                .conversionMultiple(currencyExchange.getConversionMultiple())
                .environment(environment.getProperty("local.server.port"))
                .build();

    }

}

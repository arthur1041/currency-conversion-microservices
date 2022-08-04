package com.artcruz.currencyconversionservice.proxy;

import com.artcruz.currencyconversionservice.api.response.CurrencyExchangeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    CurrencyExchangeResponse retrieveExchangeValue(@PathVariable String from, @PathVariable String to);

}

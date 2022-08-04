package com.artcruz.currencyexchangeservice.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CurrencyExchangeResponse {

    private String from;
    private String to;
    @JsonProperty("conversion-multiple")
    private BigDecimal conversionMultiple;
    private String environment;

}

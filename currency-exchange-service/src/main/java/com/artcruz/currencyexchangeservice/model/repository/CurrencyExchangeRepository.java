package com.artcruz.currencyexchangeservice.model.repository;

import com.artcruz.currencyexchangeservice.model.entity.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

    CurrencyExchange findByFromAndTo(String from, String to);

}
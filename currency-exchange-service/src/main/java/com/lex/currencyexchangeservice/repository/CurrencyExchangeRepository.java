package com.lex.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lex.currencyexchangeservice.bean.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
    CurrencyExchange findByFromAndTo(String from, String to);
}

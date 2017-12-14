package com.andreas.currencyconverter.database;

import com.andreas.currencyconverter.dto.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CurrencyDAO extends CrudRepository<Currency, Integer>{

}

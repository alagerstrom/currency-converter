package com.andreas.currencyconverter.service;

import com.andreas.currencyconverter.database.CurrencyDAO;
import com.andreas.currencyconverter.dto.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditService {

    @Autowired
    CurrencyDAO currencyDAO;

    public EditService() {

    }

    public void save(Currency currency) {
        currencyDAO.save(currency);
    }

    public void delete(int currencyId) {
        currencyDAO.delete(currencyId);
    }
}

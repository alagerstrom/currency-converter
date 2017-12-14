package com.andreas.currencyconverter.service;

import com.andreas.currencyconverter.database.CurrencyDAO;
import com.andreas.currencyconverter.dto.ConvertRequest;
import com.andreas.currencyconverter.dto.ConvertResult;
import com.andreas.currencyconverter.dto.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConvertService {

    @Autowired
    CurrencyDAO currencyDAO;

    public List<Currency> getAllCurrencies() {
        List<Currency> currencyList = new ArrayList<>();
        for (Currency currency : currencyDAO.findAll())
            currencyList.add(currency);
        return currencyList;
    }

    public ConvertResult convert(ConvertRequest convertRequest) {
        Currency fromCurrency = currencyDAO.findOne(convertRequest.getFrom());
        Currency toCurrency = currencyDAO.findOne(convertRequest.getTo());
        double amountInSek = convertRequest.getAmount() / fromCurrency.getConversionRate();
        double result = amountInSek * toCurrency.getConversionRate();
        return new ConvertResult(fromCurrency.getName(), toCurrency.getName(), convertRequest.getAmount(),result);
    }
}

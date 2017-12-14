package com.andreas.currencyconverter.controller;

import com.andreas.currencyconverter.dto.Currency;
import com.andreas.currencyconverter.service.ConvertService;
import com.andreas.currencyconverter.service.EditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditController {

    @Autowired
    EditService editService;

    @Autowired
    ConvertService convertService;

    @GetMapping("/edit")
    public String editView(Model model){
        Currency currency = new Currency();
        model.addAttribute(convertService.getAllCurrencies());
        model.addAttribute(currency);
        return "edit";
    }

    @PostMapping("/edit")
    public String addNewCurrency(@ModelAttribute Currency newCurrency, Model model){
        editService.save(newCurrency);
        model.addAttribute("result", true);
        return editView(model);
    }

    @PostMapping("/delete")
    public String deleteCurrency(@RequestParam(name = "currencyId") int currencyId, Model model){
        editService.delete(currencyId);
        return editView(model);
    }

    @GetMapping("/delete")
    public String getDeleteCurrency(@RequestParam(name = "currencyId") int currencyId, Model model){
        editService.delete(currencyId);
        return editView(model);
    }

}

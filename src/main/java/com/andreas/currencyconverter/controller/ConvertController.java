package com.andreas.currencyconverter.controller;

import com.andreas.currencyconverter.dto.ConvertRequest;
import com.andreas.currencyconverter.dto.ConvertResult;
import com.andreas.currencyconverter.service.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConvertController {

    @Autowired
    ConvertService convertService;

    @GetMapping("/")
    public String startView(Model model){
        if (!model.containsAttribute("convertRequest")){
            ConvertRequest convertRequest = new ConvertRequest();
            model.addAttribute(convertRequest);
        }
        model.addAttribute(convertService.getAllCurrencies());
        return "index";
    }

    @PostMapping("/")
    public String handleConvertRequest(@ModelAttribute ConvertRequest convertRequest, Model model){
        ConvertResult convertResult = convertService.convert(convertRequest);
        model.addAttribute(convertResult);
        model.addAttribute(convertRequest);
        return startView(model);
    }

}

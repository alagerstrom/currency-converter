package com.andreas.currencyconverter.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Currency {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    private double conversionRate;

    public double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public Currency() {
    }

    public Currency(String name, double conversionRate) {
        this.name = name;
        this.conversionRate = conversionRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
}

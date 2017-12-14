package com.andreas.currencyconverter.dto;

import java.text.DecimalFormat;

public class ConvertResult {
    private String from;
    private String to;
    private double fromAmount;
    private double toAmount;

    public ConvertResult() {
    }

    public ConvertResult(String from, String to, double fromAmount, double toAmount) {
        this.from = from;
        this.to = to;
        this.fromAmount = fromAmount;
        this.toAmount = toAmount;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public double getFromAmount() {
        return Double.parseDouble(new DecimalFormat("#0.00").format(fromAmount));
    }

    public void setFromAmount(double fromAmount) {
        this.fromAmount = fromAmount;
    }

    public double getToAmount() {
        return Double.parseDouble(new DecimalFormat("#0.00").format(toAmount));
    }

    public void setToAmount(double toAmount) {
        this.toAmount = toAmount;
    }

    @Override
    public String toString() {
        return fromAmount + " " + from + " = " + getToAmount() + " " + to;
    }
}

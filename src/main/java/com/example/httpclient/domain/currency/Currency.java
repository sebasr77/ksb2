package com.example.httpclient.domain.currency;

public class Currency {
    private Double rate;
    private CurrencyEnum currencyEnum;

    public Currency(Double rate, CurrencyEnum currencyEnum) {
        this.rate = rate;
        this.currencyEnum = currencyEnum;
    }

    public Double getRate() {
        return rate;
    }

    public CurrencyEnum getCurrencyEnum() {
        return currencyEnum;
    }
}
